package fr.kiiow.mixapi.controllers.Hench;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.models.Hench.Hench;
import fr.kiiow.mixapi.models.Hench.HenchMix;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HenchController extends AbstractController implements IHenchController {

    @GetMapping(path = "/henchs")
    public List<Hench> findAll() {
        return getDaoManager().getHenchDao().findAll();
    }

    @GetMapping(path = "/hench/{id}")
    public ResponseEntity<Optional<Hench>> findOneById(@PathVariable Integer id) {
        Optional<Hench> hench = getDaoManager().getHenchDao().findById(id);
        if(hench.isEmpty()) {
            log.warn("Hench not found with id '{}'", id);
            return this._404_Not_Found(hench);
        }
        return this.resultOk(hench);
    }

    @GetMapping(path = "/hench/{id}/evolutions")
    public ResponseEntity<List<HenchMix>> findEvolutionsById(@PathVariable Integer id) {
        Optional<Hench> hench = getDaoManager().getHenchDao().findById(id);
        if(hench.isEmpty()) {
            log.warn("Hench not found with id '{}'", id);
            return this._404_Not_Found(null);
        }
        return this.resultOk(hench.get().getHenchEvolutions());
    }

    @GetMapping(path = "/hench/{id}/mixs")
    public ResponseEntity<List<HenchMix>> findMixById(@PathVariable Integer id) {
        Optional<Hench> hench = getDaoManager().getHenchDao().findById(id);
        if(hench.isEmpty()) {
            log.warn("Hench not found with id '{}'", id);
            return this._404_Not_Found(null);
        }
        return this.resultOk(hench.get().getMix());
    }
}
