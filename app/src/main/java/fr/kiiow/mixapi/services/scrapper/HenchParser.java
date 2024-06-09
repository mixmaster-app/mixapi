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

        System.out.println("Found " + page.querySelectorAll(".hench").size() + " henchs");
        for(DomNode hench : page.querySelectorAll(".hench")) {
            HtmlElement henchModal = (HtmlElement) hench;
            System.out.println("hench id: " + henchModal.getAttribute("id"));
        }

        return henchs;
    }
}
