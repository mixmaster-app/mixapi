package fr.kiiow.mixapi.controllers.scraper;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.services.scraper.user.UserProfileParser;
import fr.kiiow.mixapi.services.scraper.user.UserProfileScraper;
import fr.kiiow.mixapi.services.scraper.user.UserScrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserScraperController extends AbstractController implements IScraperController {

    @Autowired
    private UserScrapper userScraper;

    @Autowired
    private UserProfileScraper userProfileScraper;

    @GetMapping(path = "/users/{numberOfPages}")
    public void scrapUsers(@PathVariable int numberOfPages) {
        this.log.debug("Let's scrap '{}' pages", numberOfPages);
        try {
            userScraper.scrapPages(numberOfPages);
            this.log.debug("Found '{}' profiles to scrap", userScraper.getProfileIds().size());
            for(String profileId : userScraper.getProfileIds()) {
                try {
                    UserProfileParser parser = new UserProfileParser(profileId, userProfileScraper.getPage(profileId), this.getDaoManager());
                    parser.parseUserData();
                    if(parser.getUser().isGuilded()) {
                        this.getDaoManager().getGuildDao().save(parser.getUser().getGuild());
                    }
                    this.getDaoManager().getUserDao().save(parser.getUser());
                } catch (Exception e) {
                    e.printStackTrace();
                    this.log.error("Error while parsing user profile : {}", e.getMessage());
                }
            }
        } catch (Exception e) {
            this.log.error("Error while scrapping user pages : {}", e.getMessage());
        }
    }

}
