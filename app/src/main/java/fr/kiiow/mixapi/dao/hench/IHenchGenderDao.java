package fr.kiiow.mixapi.dao.hench;

import fr.kiiow.mixapi.models.hench.HenchGender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IHenchGenderDao extends JpaRepository<HenchGender, Integer> {
    Optional<HenchGender> findByName(String name);
}
