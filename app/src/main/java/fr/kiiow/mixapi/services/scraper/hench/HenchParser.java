package fr.kiiow.mixapi.services.scraper.hench;

import fr.kiiow.mixapi.dao.DaoManager;
import fr.kiiow.mixapi.models.hench.*;
import fr.kiiow.mixapi.models.world.Item;
import fr.kiiow.mixapi.models.world.Zone;
import fr.kiiow.mixapi.services.scraper.AbstractParser;
import fr.kiiow.mixapi.services.tools.StringTools;
import lombok.Getter;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

@Getter
public class HenchParser extends AbstractParser {

    private final List<Hench> henchParsed;

    private final List<Zone> zoneParsed;

    private final List<HenchMix> henchMixesParsed;

    public HenchParser(Document pageToParse, DaoManager daoManger) {
        super(pageToParse, daoManger);
        this.henchParsed = new ArrayList<>();
        this.zoneParsed = new ArrayList<>();
        this.henchMixesParsed = new ArrayList<>();
    }

    public void parseHenchsData() {
        Elements henchsToParse = this.pageToParse.getElementsByClass("hench");
        for(Element henchDom : henchsToParse) {
            try {
                Hench hench = this.parseHench(henchDom);
                henchParsed.add(hench);
                List<HenchMix> mixs = this.parseHenchMix(henchDom, hench);
                hench.addMixes(mixs);
            } catch (Exception e) {
                log.error("Error, {}", e.getMessage());
            }
        }
    }

    protected Hench parseHench(Element henchDom) {
        Element henchModal = henchDom.expectFirst(".modal");
        Element elementStat = henchModal.expectFirst(".stat");
        Element elementSpec = elementStat.expectFirst(".spec");

        // Hench Basics
        Integer henchId = Integer.valueOf(henchDom.attr("id"));
        Hench hench = henchParsed.stream().filter(x -> x.getId().equals(henchId))
                .findFirst()
                .orElseGet(Hench::new);

        hench.setId(henchId);
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

        // Zones
        String rawHabitat = elementSpec.getElementsByClass("one").get(2).expectFirst(".s-value").text();
        if(!rawHabitat.trim().equals("-")) {
            List<String> habitats = Arrays.stream(rawHabitat.split(",")).map(String::trim).toList();
            for(String habitat: habitats) {
                Zone zone;
                Optional<Zone> zoneExist = zoneParsed.stream().filter(x -> x.getName().equals(habitat)).findFirst();

                if (zoneExist.isEmpty()) {
                    Optional<Zone> zoneDb = this.daoManager.getZoneDao().findByName(habitat);
                    if(zoneDb.isPresent()) {
                        zone = zoneDb.get();
                    } else {
                        zone = new Zone();
                        zone.setName(habitat);
                        zoneParsed.add(zone);
                    }
                } else {
                    zone = zoneExist.get();
                }
                hench.addZone(zone);
            }
        }

        return hench;
    }

    protected List<HenchMix> parseHenchMix(Element henchDom, Hench result) {
        // TODO: verify if the mix doesn't already exist in the DB
        List<HenchMix> mixes = new ArrayList<>();

        Element elementSpec = henchDom.expectFirst(".modal .stat .spec");
        Elements rawMixes = elementSpec.getElementsByClass("one").get(3).expectFirst(".s-value").children();

        for(Element mix : rawMixes) {
            mix = mix.expectFirst("div");
            // Henchs
            String henchLeftUrl = mix.getElementsByTag("a").getFirst().attr("href");
            Integer idHenchLeft = Integer.valueOf(henchLeftUrl.substring(henchLeftUrl.indexOf("idhench=") + 8));
            String henchRightUrl = mix.getElementsByTag("a").get(1).attr("href");
            Integer idHenchRight = Integer.valueOf(henchRightUrl.substring(henchRightUrl.indexOf("idhench=") + 8));

            Optional<Hench> isHenchLeft = this.daoManager.getHenchDao().findById(idHenchLeft);
            Optional<Hench> isHenchRight = this.daoManager.getHenchDao().findById(idHenchRight);

            // Items
            String[] mixesText = mix.text().split("[+]");
            Optional<Item> isItemLeft = this.daoManager.getItemDao().findByName(
                    StringTools.substring(mixesText[0], mixesText[0].indexOf("(") + 1, mixesText[0].indexOf(")")).trim()
            );
            Optional<Item> isItemRight = this.daoManager.getItemDao().findByName(
                    StringTools.substring(mixesText[1], mixesText[1].indexOf("(") + 1, mixesText[1].indexOf(")")).trim()
            );

            // Result
            HenchMix henchMix = new HenchMix();

            henchMix.setHenchResult(result);
            isHenchLeft.ifPresentOrElse(henchMix::setHenchLeft, () -> {
                Optional<Hench> isHenchParsedLeft = this.henchParsed.stream().filter(x -> x.getId().equals(idHenchLeft)).findFirst();
                isHenchParsedLeft.ifPresentOrElse(henchMix::setHenchLeft, () -> {
                    henchMix.setHenchLeft(new Hench(idHenchLeft));
                    henchParsed.add(henchMix.getHenchLeft());
                });
            });
            isHenchRight.ifPresentOrElse(henchMix::setHenchRight, () -> {
                Optional<Hench> isHenchParsedLeft = this.henchParsed.stream().filter(x -> x.getId().equals(idHenchRight)).findFirst();
                isHenchParsedLeft.ifPresentOrElse(henchMix::setHenchRight, () -> {
                    henchMix.setHenchRight(new Hench(idHenchRight));
                    henchParsed.add(henchMix.getHenchRight());
                });
            });
            isItemLeft.ifPresent(henchMix::setItemLeft);
            isItemRight.ifPresent(henchMix::setItemRight);

            // if the mix doesn't exist add it to the mixes
            if(!this.daoManager.getHenchMixDao().existsByHenchResultIdAndItemLeftIdAndHenchLeftIdAndItemRightIdAndHenchRightId(
                    henchMix.getHenchResult().getId(),
                    Optional.ofNullable(henchMix.getItemLeft())
                            .map(Item::getId)
                            .orElse(null),
                    henchMix.getHenchLeft().getId(),
                    Optional.ofNullable(henchMix.getItemRight())
                            .map(Item::getId)
                            .orElse(null),
                    henchMix.getHenchRight().getId()
            )) {
                mixes.add(henchMix);
            }
        }
        henchMixesParsed.addAll(mixes);

        return mixes;
    }
}
