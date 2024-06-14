package fr.kiiow.mixapi.controllers.scraper;

import fr.kiiow.mixapi.controllers.AbstractController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserScraperController extends AbstractController implements IScraperController {

    @GetMapping(path = "/users")
    public void scrapUsers() {

    }

}
