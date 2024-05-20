package fr.kiiow.mixapi.controllers.Hench;

import fr.kiiow.mixapi.controllers.AbstractController;
import fr.kiiow.mixapi.dao.Hench.HenchFilters;
import fr.kiiow.mixapi.models.Hench.Hench;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class HenchSearchController extends AbstractController implements IHenchController {

    @GetMapping(path = "/hench/q")
    public ResponseEntity<List<Hench>> findHenchBy(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) String types,
            @RequestParam(required = false) Integer level_minimum,
            @RequestParam(required = false) Integer level_maximum
    ) {
        Specification<Hench> filters = Specification.where(null);

        if(name != null && name.length() > 2) {
            filters = filters.and(HenchFilters.hasNameLike(name));
        }

        if(types != null && !types.isEmpty()) {
            Integer[] typesId = Stream.of(types.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
            filters = filters.and(HenchFilters.hasTypeIn(typesId));
        }

        if(level_minimum != null && level_minimum > 0) {
            filters = filters.and(HenchFilters.hasLevelGreaterThanOrEqualTo(level_minimum));
        }

        if(level_maximum != null && ( (level_minimum != null && level_maximum > level_minimum) || level_maximum > 0) ) {
            filters = filters.and(HenchFilters.hasLevelLessThanOrEqualTo(level_maximum));
        }

        List<Hench> results = getDaoManager().getHenchDao().findAll(filters);
        if(limit != null && limit > 0) {
            results = results.stream().limit(limit).toList();
        }

        return resultOk(results);
    }
}
