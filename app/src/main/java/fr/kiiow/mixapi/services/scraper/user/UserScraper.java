package fr.kiiow.mixapi.services.scraper.user;

import fr.kiiow.mixapi.models.config.Config;
import fr.kiiow.mixapi.services.scraper.AbstractScraper;
import lombok.Getter;
import org.apache.hc.core5.net.URIBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class UserScraper extends AbstractScraper {

    private static final String path = "views/tableauxclassements.php";

    protected List<String> profileIds;

    public UserScraper(Config config) {
        super(config);
    }

    @Override
    protected String getUrl() throws URISyntaxException {
        URIBuilder builder = new URIBuilder();
        builder
                .setScheme("https")
                .setHost(config.getMixmaster().getBasePath())
                .setPath(path)
        ;
        return builder.build().toString();
    }

    protected void getUsersOfPage(int pageNumber) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("tableau", "persos");
        params.put("page", String.valueOf(pageNumber));
        Document userList = Jsoup.connect(this.getUrl())
                .userAgent(config.getWebUserAgent())
                .maxBodySize(0)
                .data(params)
                .post();

        String pageContent = userList.text();
        String[] values = pageContent.split("&&&");
        if(values.length % 5 == 0) {
            for(int i = 4; i < values.length; i += 5) {
                profileIds.add(values[i]);
            }
        }

    }

    public void scrapPages(int numberOfPage) throws Exception {
        if(numberOfPage < 0) return;
        if(profileIds == null) profileIds = new ArrayList<>();

        for(int i = 1; i <= numberOfPage; i++) {
            this.getUsersOfPage(i);
        }
    }

}
