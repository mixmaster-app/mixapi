package fr.kiiow.mixapi.services.scraper.item;

import fr.kiiow.mixapi.models.config.Config;
import fr.kiiow.mixapi.services.scraper.AbstractScraper;
import org.apache.hc.core5.net.URIBuilder;

import java.net.URISyntaxException;

public class ItemScraper extends AbstractScraper {

    private static final String path = "views/tutodivers.php";

    public ItemScraper(Config config) {
        super(config);
    }

    @Override
    protected String getUrl() throws URISyntaxException {
        URIBuilder builder = new URIBuilder();
        builder
                .setScheme(config.getMixmaster().getUrlScheme())
                .setHost(config.getMixmaster().getBasePath())
                .setPath(path)
                .addParameter("quete", "oudroperitem")
        ;
        return builder.build().toString();
    }

}
