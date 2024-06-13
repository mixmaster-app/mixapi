package fr.kiiow.mixapi.services.scrapper;

import fr.kiiow.mixapi.models.config.Config;
import org.apache.hc.core5.net.URIBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

@Service
public class HenchScrapper {

    @Autowired
    private Config config;

    private static final String path = "listedeshenchs.php";

    private String getUrl() throws URISyntaxException {
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

    public Document getPage() throws Exception{
        return Jsoup.connect(this.getUrl())
                .userAgent(config.getWebUserAgent())
                .maxBodySize(0)
                .get();
    }

}
