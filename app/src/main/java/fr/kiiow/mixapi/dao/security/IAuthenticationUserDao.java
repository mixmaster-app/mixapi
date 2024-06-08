package fr.kiiow.mixapi.dao.security;

import fr.kiiow.mixapi.models.security.AuthenticationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAuthenticationUserDao extends JpaRepository<AuthenticationUser, Integer> {
    Optional<AuthenticationUser> findByUsername(String name);
    boolean existsByUsername(String username);
}
