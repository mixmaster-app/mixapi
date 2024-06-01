package fr.kiiow.mixapi.dao.User;

import fr.kiiow.mixapi.models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Integer> {
}
