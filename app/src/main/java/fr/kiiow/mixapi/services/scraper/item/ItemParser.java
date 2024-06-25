package fr.kiiow.mixapi.services.scraper.item;

import fr.kiiow.mixapi.dao.DaoManager;
import fr.kiiow.mixapi.models.hench.HenchLoots;
import fr.kiiow.mixapi.models.hench.HenchZone;
import fr.kiiow.mixapi.models.world.Item;
import fr.kiiow.mixapi.services.scraper.AbstractParser;
import lombok.Getter;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ItemParser extends AbstractParser {

    private final List<Item> itemParsed;

    private final List<HenchLoots> henchLootParsed;

    public ItemParser(Document pageToParse, DaoManager daoManager) {
        super(pageToParse, daoManager);
        this.itemParsed = new ArrayList<>();
        this.henchLootParsed = new ArrayList<>();
    }

    public void parseItems() {
        List<Element> itemsToParse = this.pageToParse.expectFirst(".TableauItemsDropables").children().stream().filter(e -> !e.tagName().equals("br")).toList();
        log.info("Found {} items to parse", itemsToParse.size());
        for(Element itemDom : itemsToParse) {
            try {
                Item item = this.parseItem(itemDom);
                this.itemParsed.add(item);
                this.henchLootParsed.addAll(this.parseHenchLoot(itemDom, item));
            } catch (Exception e) {
                log.error("Error, {}", e.getMessage());
            }
        }
    }

    protected Item parseItem(Element itemDom) {
        Item item = new Item();

        String itemImageUrl = itemDom.expectFirst("img").attr("src");
        item.setId(Integer.valueOf(itemImageUrl.substring(10, itemImageUrl.length() - 4)));
        item.setName(itemDom.expectFirst(".nom_item").text());

        return item;
    }

    protected List<HenchLoots> parseHenchLoot(Element itemDom, Item item) {
        List<HenchLoots> henchLootingItem = new ArrayList<>();

        try {
            Elements henchDropList = itemDom.getElementsByClass("bulletauxdedrop");
            for(Element henchLooting : henchDropList) {
                String textContent = henchLooting.text();
                String henchName = textContent.split("[ (]")[0].trim();
                String zoneName = textContent.substring(textContent.indexOf("(") + 1, textContent.indexOf(")"));
                Integer lootRate = Integer.valueOf(textContent.substring(textContent.indexOf("sur cette map: ") + 15));

                List<HenchZone> henchsByZone = this.getDaoManager().getHenchZoneDao().findByHenchNameAndZoneName(henchName, zoneName);

                for(HenchZone henchByZone : henchsByZone) {
                    HenchLoots henchLoots = new HenchLoots();

                    henchLoots.setHench(henchByZone.getHench());
                    henchLoots.setItem(item);
                    henchLoots.setZone(henchByZone.getZone());
                    henchLoots.setLootRate(lootRate);

                    henchLootingItem.add(henchLoots);
                }
            }
        } catch (Exception e) {
            log.error("Error parsing hench looting item, {}", e.getMessage());
        }

        return henchLootingItem;
    }
}
