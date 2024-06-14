package fr.kiiow.mixapi.services.scraper.user;

import fr.kiiow.mixapi.dao.DaoManager;
import fr.kiiow.mixapi.models.user.User;
import fr.kiiow.mixapi.services.scraper.AbstractParser;
import lombok.Getter;
import org.jsoup.nodes.Document;

@Getter
public class UserProfileParser extends AbstractParser {

    protected User user;

    public UserProfileParser(Document pageToParse, DaoManager daoManager) {
        super(pageToParse, daoManager);
    }

    public void parseUserData() {

        System.out.println("Let's parse the profile");

    }
}
