package fr.kiiow.mixapi.dao.hench;

import fr.kiiow.mixapi.models.hench.HenchNature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IHenchNatureDao extends JpaRepository<HenchNature, Integer> {
    Optional<HenchNature> findByName(String name);
}
