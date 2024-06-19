package fr.kiiow.mixapi.services.scraper.hench;

import fr.kiiow.mixapi.models.config.Config;
import fr.kiiow.mixapi.services.scraper.AbstractScraper;
import org.apache.hc.core5.net.URIBuilder;

import java.net.URISyntaxException;

public class HenchScraper extends AbstractScraper {

    private static final String path = "listedeshenchs.php";

    public HenchScraper(Config config) {
        super(config);
    }

    @Override
    protected String getUrl() throws URISyntaxException {
        URIBuilder builder = new URIBuilder();
        builder
                .setScheme("https")
                .setHost(config.getMixmaster().getBasePath())
                .setPath(path)
                .addParameter("dragon", "1")
                .addParameter("demon", "1")
                .addParameter("bete", "1")
                .addParameter("oiseau", "1")
                .addParameter("insecte", "1")
                .addParameter("plante", "1")
                .addParameter("mystere", "1")
                .addParameter("metal", "1")
                .addParameter("dropoumixouquete", "1")
                .addParameter("lvmini", "0")
                .addParameter("lvmax", "500")
        ;
        return builder.build().toString();
    }

}
