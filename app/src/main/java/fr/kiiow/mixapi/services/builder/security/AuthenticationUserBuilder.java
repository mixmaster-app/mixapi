package fr.kiiow.mixapi.services.builder.security;

import fr.kiiow.mixapi.models.security.AuthenticationUser;
import fr.kiiow.mixapi.services.security.PasswordEncoder;

public class AuthenticationUserBuilder {

    public static AuthenticationUser createAuthenticationUser(String username, String password) {
        AuthenticationUser user = new AuthenticationUser();
        user.setUsername(username);
        user.setPassword(PasswordEncoder.passwordEncoder().encode(password));
        return user;
    }
}
