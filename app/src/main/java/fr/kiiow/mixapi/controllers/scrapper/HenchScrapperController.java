package fr.kiiow.mixapi.controllers.scrapper;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.services.scrapper.hench.HenchParser;
import fr.kiiow.mixapi.services.scrapper.hench.HenchScrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HenchScrapperController extends AbstractController implements IScrapperController {

    @Autowired
    private HenchScrapper scrapper;

    @GetMapping(path = "/henchs")
    public void launchHenchScrapping() throws Exception {
        HenchParser parser = new HenchParser(scrapper.getPage(), this.getDaoManager());
        parser.parseHenchsData();
        this.getDaoManager().getZoneDao().saveAll(parser.getZoneParsed());
        this.getDaoManager().getHenchDao().saveAll(parser.getHenchParsed());
        this.getDaoManager().getHenchMixDao().saveAll(parser.getHenchMixesParsed());
    }
}
