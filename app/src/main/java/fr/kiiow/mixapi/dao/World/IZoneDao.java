package fr.kiiow.mixapi.dao.World;

import fr.kiiow.mixapi.models.World.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IZoneDao extends JpaRepository<Zone, Integer> {
}
