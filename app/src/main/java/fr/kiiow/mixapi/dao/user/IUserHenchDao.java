package fr.kiiow.mixapi.dao.user;

import fr.kiiow.mixapi.models.user.User;
import fr.kiiow.mixapi.models.user.UserHench;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserHenchDao extends JpaRepository<UserHench, Integer> {
    void deleteAllByUser(User user);
}
