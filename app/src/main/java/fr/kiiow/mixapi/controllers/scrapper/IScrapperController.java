package fr.kiiow.mixapi.controllers.scrapper;

import fr.kiiow.mixapi.controllers.ISecurityController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/scrapper")
@Tag(name = "Scrapper", description = "Launch scrapper")
public interface IScrapperController extends ISecurityController {
}
