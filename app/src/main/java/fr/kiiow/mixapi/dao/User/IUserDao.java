package fr.kiiow.mixapi.dao.User;

import fr.kiiow.mixapi.models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserDao extends JpaRepository<User, Integer> {
    List<User> findByNicknameIgnoreCaseContains(String nickname);
}
