package fr.kiiow.mixapi.dao.user;

import fr.kiiow.mixapi.models.user.UserItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserItemDao extends JpaRepository<UserItem, Integer> {
}
