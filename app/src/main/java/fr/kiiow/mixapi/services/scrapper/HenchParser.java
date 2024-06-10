package fr.kiiow.mixapi.services.scrapper;

import fr.kiiow.mixapi.dao.DaoManager;
import fr.kiiow.mixapi.models.hench.AttackType;
import fr.kiiow.mixapi.models.hench.Hench;
import fr.kiiow.mixapi.models.hench.HenchStats;
import fr.kiiow.mixapi.models.hench.HenchType;
import lombok.Getter;
import org.htmlunit.html.DomElement;
import org.htmlunit.html.HtmlElement;
import org.htmlunit.html.HtmlPage;

import java.util.*;

public class HenchParser {

    private final HtmlPage pageToParse;

    private DaoManager daoManager;

    @Getter
    private List<Hench> henchParsed;

    public HenchParser(HtmlPage pageToParse, DaoManager daoManger) {
        this.pageToParse = pageToParse;
        this.daoManager = daoManger;
        this.henchParsed = new ArrayList<>();
    }

    public void parseHenchList() {
//        System.out.println("got he following page : " + this.pageToParse.getUrl().toString());

        List<HtmlElement> henchsToParse = this.pageToParse.getByXPath("//div[@class='henchs']/div[contains(@class,'hench')]").stream().map(x -> (HtmlElement) x).toList();
        System.out.println("Found " + henchsToParse.size() + " henchs");
        for(HtmlElement henchModal : henchsToParse) {
            henchParsed.add(parseHench(henchModal));
        }
    }

    public Hench parseHench(HtmlElement henchDom) {
        Hench hench = new Hench();
        HtmlElement henchModal = henchDom.querySelector(".modal");

        // Hench Basics
        hench.setId(Integer.valueOf(henchDom.getAttribute("id")));
        hench.setName(henchModal.querySelector("h2").getTextContent());
        hench.setImage(((HtmlElement) henchDom.querySelector(".open-modal .img img")).getAttribute("src"));
        String attackTypeString = henchModal.querySelectorAll(".spec .one .s-value").getFirst().getTextContent().trim();
        hench.setAttackType(AttackType.findByText(attackTypeString).getType());

        // Hench Aquisition
        String aquireMods = henchModal.querySelectorAll(".spec .one").get(1).getTextContent();
        hench.setDropable(aquireMods.contains("Drop"));
        hench.setMixable(aquireMods.contains("Mix"));
        hench.setQuestable(aquireMods.contains("Quête"));

        // Hench Level
        String henchLevels = henchModal.querySelector(".niv").getTextContent();
        String[] henchRange = henchLevels.substring(6).split(" - ");

        hench.setMinimumLevel(Integer.valueOf(henchRange[0].trim()));
        hench.setMaximumLevel(Integer.valueOf(henchRange[1].trim()));

        // Hench type and DropRate
        String henchTypeAndDropRate = henchModal.querySelector(".stat .stars").getTextContent();

        String henchTypeString = henchTypeAndDropRate.substring(henchTypeAndDropRate.indexOf("- Hench ") + 8);
        Optional<HenchType> typeExist = this.daoManager.getHenchTypeDao().findByName(henchTypeString);
        typeExist.ifPresent(hench::setType);

        String henchDropRate = null;
        if(henchTypeAndDropRate.contains("drop: ")) {
            henchDropRate = henchTypeAndDropRate.substring(henchTypeAndDropRate.indexOf("drop: ") + 6, henchTypeAndDropRate.indexOf(" - "));
        }

        // Hench stats
        Map<String, String> rawStats = new HashMap<>();
        for (DomElement stat : ((HtmlElement) henchModal.querySelector(".statistiques .skills")).getChildElements()) {
            if ("div".equals(stat.getTagName())) {
                HtmlElement title = stat.querySelector(".s-title");
                HtmlElement value = stat.querySelector(".s-value > div");

                if (title != null && value != null) {
                    rawStats.put(title.getTextContent(), value.getTextContent());
                }
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

        System.out.println(hench);
        return hench;
    }
}
