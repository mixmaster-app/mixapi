package fr.kiiow.mixapi.services.scrapper;

import fr.kiiow.mixapi.models.config.Config;
import org.apache.http.client.utils.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class HenchScrapper {

    @Autowired
    private Config config;

    private static final Logger log = LogManager.getLogger();

    private static final String path = "listedeshenchs.php";

    private URL getUrl() throws URISyntaxException, MalformedURLException {
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
                .addParameter("lvmax", "1")
        ;
        return builder.build().toURL();
    }

    public HtmlPage getPage() throws Exception{
        HtmlPage page = null;
        try (WebClient client = new WebClient()) {
            page = client.getPage(this.getUrl());
        } catch (Exception e) {
            log.error("Error, {}", e.getMessage());
            throw e;
        }
        return page;
    }

}
