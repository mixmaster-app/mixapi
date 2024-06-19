package fr.kiiow.mixapi.services.scraper.user;

import fr.kiiow.mixapi.models.config.Config;
import fr.kiiow.mixapi.services.scraper.AbstractScraper;
import org.apache.hc.core5.net.URIBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.URISyntaxException;

public class UserProfileScraper extends AbstractScraper {

    public UserProfileScraper(Config config) {
        super(config);
    }

    @Override
    protected String getUrl() {
        throw new RuntimeException("Not implemented");
    }

    // https://mixmaster-online.fr/perso-6622233043748917257.html
    protected String getUrl(String profileId) throws URISyntaxException {
        URIBuilder builder = new URIBuilder();
        builder
                .setScheme("https")
                .setHost(config.getMixmaster().getBasePath())
                .setPath("perso-" + profileId + ".html")
        ;
        return builder.build().toString();
    }

    public Document getPage(String profileId) throws Exception {
        return Jsoup.connect(this.getUrl(profileId))
                .userAgent(config.getWebUserAgent())
                .maxBodySize(0)
                .get();
    }
}
