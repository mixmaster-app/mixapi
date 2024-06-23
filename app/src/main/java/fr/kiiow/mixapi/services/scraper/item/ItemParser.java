package fr.kiiow.mixapi.services.scraper.item;

import fr.kiiow.mixapi.dao.DaoManager;
import fr.kiiow.mixapi.models.hench.HenchLoots;
import fr.kiiow.mixapi.models.world.Item;
import fr.kiiow.mixapi.services.scraper.AbstractParser;
import lombok.Getter;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

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
        for(Element itemDom : itemsToParse) {
            try {

            } catch (Exception e) {
                log.error("Error, {}", e.getMessage());
            }
        }
    }

    protected Item parseItem(Element itemDom) {
        return null;
    }

    protected HenchLoots parseHenchLoot(Element itemDom) {
        return null;
    }
}
