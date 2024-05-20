package fr.kiiow.mixapi.dao.Hench;

import fr.kiiow.mixapi.models.Hench.Hench;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHenchDao extends JpaRepository<Hench, Integer> {
}
