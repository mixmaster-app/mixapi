package fr.kiiow.mixapi.dao.user;

import fr.kiiow.mixapi.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserDao extends JpaRepository<User, String> {
    List<User> findByNicknameIgnoreCaseContains(String nickname);
}
