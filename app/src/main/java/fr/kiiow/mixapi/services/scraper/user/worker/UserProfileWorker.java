package fr.kiiow.mixapi.services.scraper.user.worker;

import fr.kiiow.mixapi.dao.DaoManager;
import fr.kiiow.mixapi.services.scraper.user.UserProfileParser;
import fr.kiiow.mixapi.services.scraper.user.UserProfileScraper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserProfileWorker implements Runnable {

    protected final Logger log = LogManager.getLogger();

    public UserProfileScraper userProfileScraper;

    public DaoManager daoManager;

    public String profileId;

    public UserProfileWorker(UserProfileScraper userProfileScraper, DaoManager daoManager, String profileId) {
        this.userProfileScraper = userProfileScraper;
        this.daoManager = daoManager;
        this.profileId = profileId;
    }

    @Override
    public void run() {
        try {
            UserProfileParser parser = new UserProfileParser(profileId, userProfileScraper.getPage(profileId), daoManager);
            parser.parseUserData();
            parser.saveUserData();
            log.info("- [{}]", profileId);
        } catch (Exception e) {
            log.error("Error while parsing user profile({}) : {}", profileId, e.getMessage());
        }
    }
}
