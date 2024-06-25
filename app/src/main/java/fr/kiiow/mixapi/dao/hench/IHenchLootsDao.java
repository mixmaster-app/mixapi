package fr.kiiow.mixapi.dao.hench;

import fr.kiiow.mixapi.models.hench.HenchLoots;
import fr.kiiow.mixapi.models.hench.HenchLoots_Key;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHenchLootsDao extends JpaRepository<HenchLoots, HenchLoots_Key> {
}
