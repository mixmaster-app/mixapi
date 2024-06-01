package fr.kiiow.mixapi.dao.Guild;

import fr.kiiow.mixapi.models.Guild.Guild;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGuildDao extends JpaRepository<Guild, Integer> {
    List<Guild> findByNameIgnoreCaseContains(String name);
}
