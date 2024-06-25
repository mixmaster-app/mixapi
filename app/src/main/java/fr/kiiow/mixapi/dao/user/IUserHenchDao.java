package fr.kiiow.mixapi.dao.user;

import fr.kiiow.mixapi.models.user.UserHench;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserHenchDao extends JpaRepository<UserHench, Integer> {
    @Transactional
    void deleteByUserId(String userId);
}
