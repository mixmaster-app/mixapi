package fr.kiiow.mixapi.controllers.World;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.models.World.Zone;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "World", description = "Mixmaster worlds data")
public class ZoneController extends AbstractController {

    @GetMapping(path = "/zones")
    public List<Zone> findAllZones() {
        return (List<Zone>) getDaoManager().getZoneDao().findAll();
    }
}
