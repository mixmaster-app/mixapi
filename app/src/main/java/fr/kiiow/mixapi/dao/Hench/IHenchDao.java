package fr.kiiow.mixapi.dao.Hench;

import fr.kiiow.mixapi.models.Hench.Hench;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IHenchDao extends JpaRepository<Hench, Integer>, JpaSpecificationExecutor<Hench> {
    List<Hench> findByNameContains(String name);
}
