package fr.kiiow.mixapi.controllers.hench;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.models.hench.Hench;
import fr.kiiow.mixapi.models.hench.HenchMix;
import fr.kiiow.mixapi.services.compute.HenchDropRate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
        return this.resultOk(hench.get().getMixes());
    }

    @GetMapping(path = "/hench/{id}/droprate")
    public ResponseEntity<Double> getDropRate(
            @PathVariable(name = "id") Integer id,
            @RequestParam(name = "lvl_user") Integer userLevel,
            @RequestParam(name = "mark_rate") Integer markRate,
            @RequestParam(name = "server_rate", required = false, defaultValue = "7") Integer serverRate
            ) {
        Optional<Hench> isHench = getDaoManager().getHenchDao().findById(id);
        if(isHench.isEmpty()) {
            log.warn("Hench not found with id '{}'", id);
            return this._404_Not_Found(null);
        }

        return this.resultOk(HenchDropRate.compute(isHench.get(), userLevel, markRate, serverRate));
    }
}
