package fr.kiiow.mixapi.controllers.scraper;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.services.scraper.user.UserProfileScraper;
import fr.kiiow.mixapi.services.scraper.user.UserScraper;
import fr.kiiow.mixapi.services.scraper.user.worker.UserProfileWorker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class UserScraperController extends AbstractController implements IScraperController {

    @GetMapping(path = "/users/{numberOfPages}")
    public List<String> scrapUsers(@PathVariable int numberOfPages) {
        long startTime = System.nanoTime();
        List<String> errors = new ArrayList<>();
        log.info("Let's scrap '{}' pages", numberOfPages);
        try {
            UserScraper userScraper = new UserScraper(getConfig());
            userScraper.scrapPages(numberOfPages);
            log.info("Found '{}' profiles to scrap", userScraper.getProfileIds().size());

            try (ExecutorService threadPool = Executors.newFixedThreadPool(20)) {
                for(String profileId : userScraper.getProfileIds()) {
                    threadPool.execute(() -> {
                        if(!(new UserProfileWorker(new UserProfileScraper(getConfig()), getDaoManager(), profileId)).execute()) {
                            errors.add(profileId);
                        }
                    });
                }
            } catch (Exception e) {
                log.error("Error, {}", e.getMessage());
            }

        } catch (Exception e) {
            log.error("Error while scrapping user pages : {}", e.getMessage());
        }
        log.info("Execution time in {}ms", (System.nanoTime() - startTime) / 1000000);

        return errors;
    }

    @GetMapping(path = "/user/{profileId}")
    public boolean scrapUser(@PathVariable String profileId) {
        return (new UserProfileWorker(new UserProfileScraper(getConfig()), getDaoManager(), profileId)).execute();
    }

}
