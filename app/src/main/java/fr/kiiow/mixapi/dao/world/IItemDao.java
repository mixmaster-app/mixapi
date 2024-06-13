package fr.kiiow.mixapi.dao.world;

import fr.kiiow.mixapi.models.world.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IItemDao extends JpaRepository<Item, Integer> {
    Optional<Item> findByName(String name);
}
