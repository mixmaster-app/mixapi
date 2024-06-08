package fr.kiiow.mixapi.controllers.security;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.services.builder.security.AuthenticationUserBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController extends AbstractController implements IAuthenticationController {

    @PostMapping("/register")
    public boolean register(@RequestBody String username, @RequestBody String password) {
        if(this.getDaoManager().getAuthenticationUserDao().existsByUsername(username)) {
            return false;
        }
        this.getDaoManager().getAuthenticationUserDao().save(AuthenticationUserBuilder.createAuthenticationUser(username, password));
        return true;
    }
}
