package fr.kiiow.mixapi.controllers.scraper;

import fr.kiiow.mixapi.controllers.ISecurityController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/scraper")
@Tag(name = "Scraper", description = "Launch scraper")
public interface IScraperController extends ISecurityController {
}
