package fr.kiiow.mixapi.services.security;

import fr.kiiow.mixapi.dao.DaoManager;
import fr.kiiow.mixapi.models.security.AuthenticationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    DaoManager daoManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthenticationUser> authenticatedUser = daoManager.getAuthenticationUserDao().findByUsername(username);
        if(authenticatedUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        AuthenticationUser user = authenticatedUser.get();
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
