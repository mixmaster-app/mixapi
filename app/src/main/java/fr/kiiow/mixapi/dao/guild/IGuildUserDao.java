package fr.kiiow.mixapi.dao.guild;

import fr.kiiow.mixapi.models.guild.GuildUser;
import fr.kiiow.mixapi.models.guild.GuildUser_Key;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGuildUserDao extends JpaRepository<GuildUser, GuildUser_Key> {
}
