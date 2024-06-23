package fr.kiiow.mixapi.services.scraper.user;

import fr.kiiow.mixapi.dao.DaoManager;
import fr.kiiow.mixapi.models.guild.Guild;
import fr.kiiow.mixapi.models.hench.Hench;
import fr.kiiow.mixapi.models.hench.HenchGender;
import fr.kiiow.mixapi.models.hench.HenchNature;
import fr.kiiow.mixapi.models.user.CharacterType;
import fr.kiiow.mixapi.models.user.User;
import fr.kiiow.mixapi.models.user.UserHench;
import fr.kiiow.mixapi.models.user.UserItem;
import fr.kiiow.mixapi.models.world.Item;
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

        // Guild
        Element guildLink = userBasics.expectFirst("a");
        String guildLinkHref = guildLink.attr("href");
        String guildId = guildLinkHref.substring(7, guildLinkHref.indexOf(".html"));
        if(!guildId.isEmpty()) {
            Integer guildRealId = Integer.valueOf(guildId);
            Optional<Guild> isGuild = this.getDaoManager().getGuildDao().findById(guildRealId);
            isGuild.ifPresentOrElse(user::setGuild, () -> user.setGuild(new Guild(guildRealId, guildLink.text())));
        }

        // Hench
        for(Element henchToParse : pageToParse.expectFirst(".henchs").children()) {
            try {
                UserHench hench = new UserHench();
                hench.setUser(user);

                Optional<Hench> isHench = this.daoManager.getHenchDao().findById(Integer.valueOf(henchToParse.attr("id").replace("-recap", "")));
                isHench.ifPresent(hench::setHench);
                String[] henchLevels = henchToParse.expectFirst(".niv").text().substring(6).split(" - ");
                hench.setLevel(Integer.valueOf(henchLevels[0].trim()));
                hench.setMaximumLevel(Integer.valueOf(henchLevels[1].trim()));

                String henchInfo = henchToParse.expectFirst("h2").text();
                String[] henchNatureAndGender = henchInfo.substring(henchInfo.indexOf("(") + 1, henchInfo.length() - 1).trim().split(" - ");

                Optional<HenchNature> isHenchNature = this.daoManager.getHenchNatureDao().findByName(henchNatureAndGender[0]);
                Optional<HenchGender> isHenchGender = this.daoManager.getHenchGenderDao().findByName(henchNatureAndGender[1]);

                isHenchNature.ifPresent(hench::setNature);
                isHenchGender.ifPresent(hench::setGender);

                user.addHench(hench);
            } catch (Exception e) {
                log.warn("Error while parsing hench, {}", e.getMessage());
            }
        }

        // Item
        if(pageToParse.is(".items")) {
            for(Element itemToParse : pageToParse.expectFirst(".items").children()) {
                try {
                    UserItem item = new UserItem();
                    item.setUser(user);
                    item.setQuantity(Integer.valueOf(itemToParse.expectFirst(".img .number").text().replace("x", "")));
                    // TODO: Change findByName with a findById using img id, once the item scraper is done
                    Optional<Item> isItem = this.daoManager.getItemDao().findByName(itemToParse.expectFirst(".info h2").text());
                    isItem.ifPresent(item::setItem);

                    user.addItem(item);
                } catch (Exception e) {
                    log.warn("Error while parsing item, {}", e.getMessage());
                }
            }
        }

    }

    public void saveUserData() {
        if(this.getUser().isGuilded()) {
            try {
                this.getDaoManager().getGuildDao().save(this.getUser().getGuild());
            } catch (Exception e) {
                log.warn("Error while saving guild, {}", e.getMessage());
            }
        }
        this.getDaoManager().getUserHenchDao().deleteAll();
        this.getDaoManager().getUserItemDao().deleteAll();

        if(this.getUser().getHenchs() != null) {
            this.getDaoManager().getUserHenchDao().saveAll(this.getUser().getHenchs());
        }
        if(this.getUser().getItems() != null) {
            this.getDaoManager().getUserItemDao().saveAll(this.getUser().getItems());
        }
        this.getDaoManager().getUserDao().save(this.getUser());
    }
}
