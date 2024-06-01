package fr.kiiow.mixapi.controllers.User;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.models.User.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController extends AbstractController implements IUserController {

    @GetMapping(path = "/users")
    private List<User> findAllUsers() {
        return this.getDaoManager().getUserDao().findAll();
    }
}
