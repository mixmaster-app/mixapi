package fr.kiiow.mixapi.dao.Guild;

import fr.kiiow.mixapi.models.Guild.GuildUser;
import fr.kiiow.mixapi.models.Guild.GuildUserKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGuildUserDao extends JpaRepository<GuildUser, GuildUserKey> {
}
