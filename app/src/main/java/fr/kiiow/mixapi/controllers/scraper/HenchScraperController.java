package fr.kiiow.mixapi.controllers.scraper;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.services.scraper.hench.HenchParser;
import fr.kiiow.mixapi.services.scraper.hench.HenchScraper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HenchScraperController extends AbstractController implements IScraperController {

    @GetMapping(path = "/henchs")
    public void scrapHenchs() throws Exception {
        HenchParser parser = new HenchParser((new HenchScraper(getConfig())).getPage(), this.getDaoManager());
        parser.parseHenchsData();
        this.getDaoManager().getZoneDao().saveAll(parser.getZoneParsed());
        this.getDaoManager().getHenchDao().saveAll(parser.getHenchParsed());
        this.getDaoManager().getHenchMixDao().saveAll(parser.getHenchMixesParsed());
    }
}
