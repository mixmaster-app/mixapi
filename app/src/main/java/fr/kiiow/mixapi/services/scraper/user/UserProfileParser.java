package fr.kiiow.mixapi.services.scraper.user;

import fr.kiiow.mixapi.dao.DaoManager;
import fr.kiiow.mixapi.models.guild.Guild;
import fr.kiiow.mixapi.models.user.CharacterType;
import fr.kiiow.mixapi.models.user.User;
import fr.kiiow.mixapi.services.scraper.AbstractParser;
import lombok.Getter;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Optional;

@Getter
public class UserProfileParser extends AbstractParser {

    protected User user;

    public UserProfileParser(String profileId, Document pageToParse, DaoManager daoManager) {
        super(pageToParse, daoManager);
        this.user = new User();
        user.setId(profileId);
    }

    public void parseUserData() {
        Element userBasics = pageToParse.expectFirst(".contenu_ficheperso .titres");

        // Basics
        String[] userElements = userBasics.text().split(" - ");
        user.setNickname(userElements[0].trim());
        user.setLevel(Integer.valueOf(userElements[1].substring(userElements[1].indexOf("Lv. ") + 4, userElements[1].indexOf(" et ")).trim()));
        user.setLevelPercent(Float.valueOf(userElements[1].substring(userElements[1].indexOf(" et ") + 4, userElements[1].indexOf("%")).trim()));

        Optional<CharacterType> isCharacterType = this.getDaoManager().getCharacterTypeDao().findByName(userElements[2].trim());
        isCharacterType.ifPresent(user::setCharacterType);

        Element guildLink = userBasics.expectFirst("a");
        String guildLinkHref = guildLink.attr("href");
        String guildId = guildLinkHref.substring(7, guildLinkHref.indexOf(".html"));
        if(!guildId.isEmpty()) {
            Integer guildRealId = Integer.valueOf(guildId);
            Optional<Guild> isGuild = this.getDaoManager().getGuildDao().findById(guildRealId);
            isGuild.ifPresentOrElse(user::setGuild, () -> {
                user.setGuild(new Guild(guildRealId, guildLink.text()));
            });
        }
    }
}
