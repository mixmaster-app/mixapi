package fr.kiiow.mixapi.dao.world;

import fr.kiiow.mixapi.models.world.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IZoneDao extends JpaRepository<Zone, Integer> {
    Optional<Zone> findByName(String name);
}
