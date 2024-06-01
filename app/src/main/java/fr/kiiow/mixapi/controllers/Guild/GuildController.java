package fr.kiiow.mixapi.controllers.Guild;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.models.Guild.Guild;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuildController extends AbstractController implements IGuildController {

    @GetMapping(path = "/guilds")
    public List<Guild> findAllGuids() {
        return this.getDaoManager().getGuildDao().findAll();
    }
}
