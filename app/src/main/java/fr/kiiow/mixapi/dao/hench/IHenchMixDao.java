package fr.kiiow.mixapi.dao.hench;

import fr.kiiow.mixapi.models.hench.HenchMix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHenchMixDao extends JpaRepository<HenchMix, Integer> {
}
