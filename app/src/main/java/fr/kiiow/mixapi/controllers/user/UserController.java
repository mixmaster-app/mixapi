package fr.kiiow.mixapi.controllers.user;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.models.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController extends AbstractController implements IUserController {

    @GetMapping(path = "/users")
    public List<User> findAll() {
        return this.getDaoManager().getUserDao().findAll();
    }

    @GetMapping(path = "/user/{id}")
    public Optional<User> findOneById(@PathVariable String id) {
        return this.getDaoManager().getUserDao().findById(id);
    }

    @GetMapping(path = "/users/q")
    public List<User> findAllByName(@RequestParam String search) {
        return this.getDaoManager().getUserDao().findByNicknameIgnoreCaseContains(search);
    }
}
