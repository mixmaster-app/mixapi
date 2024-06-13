package fr.kiiow.mixapi.services.scrapper;

import fr.kiiow.mixapi.dao.DaoManager;
import fr.kiiow.mixapi.models.hench.AttackType;
import fr.kiiow.mixapi.models.hench.Hench;
import fr.kiiow.mixapi.models.hench.HenchStats;
import fr.kiiow.mixapi.models.hench.HenchType;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class HenchParser {

    private final static Logger log = LogManager.getLogger();

    private final Document pageToParse;

    private final DaoManager daoManager;

    @Getter
    private final List<Hench> henchParsed;

    public HenchParser(Document pageToParse, DaoManager daoManger) {
        this.pageToParse = pageToParse;
        this.daoManager = daoManger;
        this.henchParsed = new ArrayList<>();
    }

    public void parseHenchList() {
        System.out.println("Go to : " + this.pageToParse.baseUri());

        Elements henchsToParse = this.pageToParse.getElementsByClass("hench");
        System.out.println("Found '" + henchsToParse.size() + "' henchs to parse");
        for(Element henchDom : henchsToParse) {
            try {
                henchParsed.add(this.parseHench(henchDom));
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Error, {}", e.getMessage());
            }
        }
    }

    public Hench parseHench(Element henchDom) {
        Hench hench = new Hench();
        Element henchModal = henchDom.expectFirst(".modal");
        Element elementStat = henchModal.expectFirst(".stat");
        Element elementSpec = elementStat.expectFirst(".spec");

        // Hench Basics
        hench.setId(Integer.valueOf(henchDom.attr("id")));
        hench.setName(Objects.requireNonNull(henchModal.getElementsByTag("h2").first()).text());
        hench.setImage(henchDom.expectFirst(".open-modal .img img").attr("src"));

        String attackTypeString = elementSpec.getElementsByClass("one").getFirst().text().trim();
        hench.setAttackType(AttackType.findByText(attackTypeString).getType());
        // Hench Aquisition
        String aquireMods = elementSpec.getElementsByClass("one").get(1).text();
        hench.setDropable(aquireMods.contains("Drop"));
        hench.setMixable(aquireMods.contains("Mix"));
        hench.setQuestable(aquireMods.contains("Quête"));

        // Hench Level
        String henchLevels = henchModal.getElementsByClass("niv").getFirst().text();
        String[] henchRange = henchLevels.substring(6).split(" - ");

        hench.setMinimumLevel(Integer.valueOf(henchRange[0].trim()));
        hench.setMaximumLevel(Integer.valueOf(henchRange[1].trim()));

        // Hench type and DropRate
        String henchTypeAndDropRate = elementStat.getElementsByClass("stars").text();

        String henchTypeString = henchTypeAndDropRate.substring(henchTypeAndDropRate.indexOf("Hench ") + 6);
        Optional<HenchType> typeExist = this.daoManager.getHenchTypeDao().findByName(henchTypeString);
        typeExist.ifPresent(hench::setType);

        if(henchTypeAndDropRate.contains("drop: ")) {
            hench.setDropRate(Integer.valueOf(henchTypeAndDropRate.substring(henchTypeAndDropRate.indexOf("drop: ") + 6, henchTypeAndDropRate.indexOf(" - "))));
        }

        // Hench stats
        Map<String, String> rawStats = new HashMap<>();
        for (Element stat : henchModal.expectFirst(".statistiques .skills").children()) {
            if ("div".equals(stat.tagName())) {
                Element title = stat.expectFirst(".s-title");
                Element value = stat.expectFirst(".s-value > div");

                rawStats.put(title.text(), value.text());
            }
        }
        HenchStats henchStats = new HenchStats();
        henchStats.setHp(Integer.valueOf(rawStats.get("HP")));
        henchStats.setMp(Integer.valueOf(rawStats.get("MP")));
        henchStats.setAttack(rawStats.get("ATTAQUE"));
        henchStats.setPower(Integer.valueOf(rawStats.get("PUISSANCE")));
        henchStats.setSpeed(Integer.valueOf(rawStats.get("VITESSE")));
        henchStats.setAccuracy(Integer.valueOf(rawStats.get("PRECISION")));
        henchStats.setLuck(Integer.valueOf(rawStats.get("CHANCE")));

        hench.setStats(henchStats);

        List<String> habitats = Arrays.stream(elementSpec.getElementsByClass("one").get(2).expectFirst(".s-value").text().split(",")).map(String::trim).toList();
        System.out.println("Hench habitats " + habitats);

        return hench;
    }
}
