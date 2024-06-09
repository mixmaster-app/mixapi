package fr.kiiow.mixapi.services.scrapper;

import fr.kiiow.mixapi.models.hench.Hench;
import org.htmlunit.html.DomNode;
import org.htmlunit.html.HtmlElement;
import org.htmlunit.html.HtmlPage;

import java.util.ArrayList;
import java.util.List;

public class HenchParser {

    public static List<Hench> parseHenchList(HtmlPage page) {
        System.out.println("got he following page : " + page.getUrl().toString());
        List<Hench> henchs = new ArrayList<>();

        List<HtmlElement> henchsToParse = page.getByXPath("//div[@class='henchs']/div[contains(@class,'hench')]").stream().map(x -> (HtmlElement) x).toList();
        System.out.println("Found " + henchsToParse.size() + " henchs");
        for(HtmlElement henchModal : henchsToParse) {
            henchs.add(parseHench(henchModal));
        }

        return henchs;
    }

    public static Hench parseHench(HtmlElement henchDom) {
        Hench hench = new Hench();
        HtmlElement henchModal = henchDom.querySelector(".modal");
        hench.setId(Integer.valueOf(henchDom.getAttribute("id")));
        hench.setName(henchModal.querySelector("h2").getTextContent());
        // hench.setType();
        // hench.setAttackType();

        String aquireMods = henchModal.querySelectorAll(".spec .one").get(1).getTextContent();
        hench.setDropable(aquireMods.contains("Drop"));
        hench.setMixable(aquireMods.contains("Mix"));
        hench.setQuestable(aquireMods.contains("Quête"));

        String henchLevels = henchModal.querySelector(".niv").getTextContent();
        String[] henchRange = henchLevels.substring(6).split(" - ");

        hench.setMinimumLevel(Integer.valueOf(henchRange[0].trim()));
        hench.setMaximumLevel(Integer.valueOf(henchRange[1].trim()));

        String henchTypeAndDropRate = henchModal.querySelector(".stat .stars").getTextContent();
        String henchTypeString = henchTypeAndDropRate.substring(henchTypeAndDropRate.indexOf("- Hench ") + 8);
        String henchDropRate = null;
        if(henchTypeAndDropRate.contains("drop: ")) {
            henchDropRate = henchTypeAndDropRate.substring(henchTypeAndDropRate.indexOf("drop: ") + 6, henchTypeAndDropRate.indexOf(" - "));
        }

        for(HtmlElement stat : henchModal.querySelectorAll(".statistiques .skills div").stream().map(x -> (HtmlElement) x).toList()) {
            System.out.println(stat.querySelector(".s-title").getTextContent().trim());
            System.out.println(stat.querySelector(".s-value").getTextContent().trim());
        }

        return hench;
    }
}
