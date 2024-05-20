package fr.kiiow.mixapi.controllers.Hench;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.models.Hench.Hench;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Hench")
public class HenchController extends AbstractController {

    @GetMapping(path = "/henchs")
    public List<Hench> findAllHenchs() {
        return getDaoManager().getHenchDao().findAll();
    }

    @GetMapping(path = "/hench/{id}")
    public ResponseEntity<?> findOneById(@PathVariable Integer id) {
        Optional<Hench> isHenchExistent = getDaoManager().getHenchDao().findById(id);
        if(isHenchExistent.isEmpty()) {
            String message = "Hench not found with id '" + id + "'";
            return this._404_Not_Found(message);
        }
        return this.resultOk(isHenchExistent.get());
    }
}
