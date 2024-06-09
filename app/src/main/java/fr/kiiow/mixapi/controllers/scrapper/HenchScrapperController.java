package fr.kiiow.mixapi.controllers.scrapper;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.models.hench.Hench;
import fr.kiiow.mixapi.services.scrapper.HenchParser;
import fr.kiiow.mixapi.services.scrapper.HenchScrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HenchScrapperController extends AbstractController implements IScrapperController {

    @Autowired
    private HenchScrapper scrapper;

    @GetMapping(path = "/henchs")
    public void launchHenchScrapping() throws Exception {
        HenchParser parser = new HenchParser(scrapper.getPage(), this.getDaoManager());
        parser.parseHenchList();
        this.getDaoManager().getHenchDao().saveAll(parser.getHenchParsed());
    }
}
