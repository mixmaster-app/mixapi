package fr.kiiow.mixapi.dao.Guild;

import fr.kiiow.mixapi.models.Guild.Guild;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGuildDao extends JpaRepository<Guild, Integer> {
}
