package fr.kiiow.mixapi.controllers.scraper;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.services.scraper.user.UserProfileScraper;
import fr.kiiow.mixapi.services.scraper.user.UserScraper;
import fr.kiiow.mixapi.services.scraper.user.worker.UserProfileWorker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserScraperController extends AbstractController implements IScraperController {

    @GetMapping(path = "/users/{numberOfPages}")
    public void scrapUsers(@PathVariable int numberOfPages) {
        long startTime = System.nanoTime();
        log.debug("Let's scrap '{}' pages", numberOfPages);
        try {
            UserScraper userScraper = new UserScraper(getConfig());
            userScraper.scrapPages(numberOfPages);
            log.debug("Found '{}' profiles to scrap", userScraper.getProfileIds().size());
            for(String profileId : userScraper.getProfileIds()) {
                log.info("+ [{}]", profileId);
                new Thread(new UserProfileWorker(new UserProfileScraper(getConfig()), getDaoManager(), profileId)).start();
            }
        } catch (Exception e) {
            log.error("Error while scrapping user pages : {}", e.getMessage());
        }
    }

}
