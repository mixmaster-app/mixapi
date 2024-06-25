package fr.kiiow.mixapi.dao.hench;

import fr.kiiow.mixapi.models.hench.HenchZone;
import fr.kiiow.mixapi.models.hench.HenchZone_Key;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IHenchZoneDao extends JpaRepository<HenchZone, HenchZone_Key> {
    List<HenchZone> findByHenchNameAndZoneName(String henchName, String zoneName);
}
