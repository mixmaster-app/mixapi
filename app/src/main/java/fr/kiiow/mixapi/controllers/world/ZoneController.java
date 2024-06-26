package fr.kiiow.mixapi.controllers.world;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.models.world.Zone;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZoneController extends AbstractController implements IWorldController {

    @GetMapping(path = "/zones")
    public List<Zone> findAll() {
        return (List<Zone>) getDaoManager().getZoneDao().findAll();
    }
}
