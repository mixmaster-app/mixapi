package fr.kiiow.mixapi.dao.user;

import fr.kiiow.mixapi.models.user.CharacterType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICharacterTypeDao extends JpaRepository<CharacterType, Integer> {
    Optional<CharacterType> findByName(String name);
}
