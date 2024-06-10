package fr.kiiow.mixapi.dao.hench;

import fr.kiiow.mixapi.models.hench.HenchType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IHenchTypeDao extends JpaRepository<HenchType, Integer> {
    Optional<HenchType> findByName(String name);
}
