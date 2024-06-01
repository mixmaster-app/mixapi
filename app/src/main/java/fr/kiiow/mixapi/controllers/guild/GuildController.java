package fr.kiiow.mixapi.controllers.guild;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.models.guild.Guild;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class GuildController extends AbstractController implements IGuildController {

    @GetMapping(path = "/guilds")
    public List<Guild> findAll() {
        return this.getDaoManager().getGuildDao().findAll();
    }

    @GetMapping(path = "/guild/{id}")
    public Optional<Guild> findOneById(@PathVariable Integer id) {
        return this.getDaoManager().getGuildDao().findById(id);
    }

    @GetMapping(path = "/guilds/q")
    public List<Guild> findAllByName(@RequestParam String search) {
        return this.getDaoManager().getGuildDao().findByNameIgnoreCaseContains(search);
    }
}
