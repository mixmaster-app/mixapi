package fr.kiiow.mixapi.dao.hench;

import fr.kiiow.mixapi.models.hench.Hench;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface IHenchDao extends JpaRepository<Hench, Integer>, JpaSpecificationExecutor<Hench> {
    Optional<Hench> findByNameEquals(String name);
}
