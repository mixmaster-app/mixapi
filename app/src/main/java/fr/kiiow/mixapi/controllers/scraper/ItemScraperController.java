package fr.kiiow.mixapi.controllers.scraper;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.services.scraper.item.ItemParser;
import fr.kiiow.mixapi.services.scraper.item.ItemScraper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemScraperController extends AbstractController implements IScraperController {

    @GetMapping("/items")
    public void scrapItems() {
        ItemScraper itemScraper = new ItemScraper(this.getConfig());
        try {
            ItemParser parser = new ItemParser(itemScraper.getPage(), this.getDaoManager());
            parser.parseItems();
            this.getDaoManager().getItemDao().saveAll(parser.getItemParsed());
            this.getDaoManager().getHenchLootsDao().saveAll(parser.getHenchLootParsed());
        } catch (Exception e) {
            log.error("Error, {}", e.getMessage());
        }
    }
}
