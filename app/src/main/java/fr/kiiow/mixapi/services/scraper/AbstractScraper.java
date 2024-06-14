package fr.kiiow.mixapi.services.scraper;

import fr.kiiow.mixapi.models.config.Config;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URISyntaxException;

public abstract class AbstractScraper {

    @Autowired
    protected Config config;

    abstract protected String getUrl() throws URISyntaxException;

    public Document getPage() throws Exception{
        return Jsoup.connect(this.getUrl())
                .userAgent(config.getWebUserAgent())
                .maxBodySize(0)
                .get();
    }
}
