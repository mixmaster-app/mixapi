package fr.kiiow.mixapi.controllers.security;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.services.builder.security.AuthenticationUserBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController extends AbstractController implements IAuthenticationController {

    @PostMapping("/register")
    public boolean register(@RequestBody RegisterUser user) {
        if(this.getDaoManager().getAuthenticationUserDao().existsByUsername(user.username)) {
            return false;
        }
        this.getDaoManager().getAuthenticationUserDao().save(AuthenticationUserBuilder.createAuthenticationUser(user.username, user.password));
        return true;
    }

    public record RegisterUser(String username, String password) { }
}
