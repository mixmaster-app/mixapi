package fr.kiiow.mixapi.dao.Hench;

import fr.kiiow.mixapi.models.Hench.Hench;
import org.springframework.data.jpa.domain.Specification;

public class HenchFilters {

    public static Specification<Hench> hasNameLike(String name) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%"));
    }

    public static Specification<Hench> hasTypeIn(Integer[] types) {
        return ((root, query, criteriaBuilder) -> root.get("type").get("id").in((Object[]) types));
    }

    public static Specification<Hench> hasLevelGreaterThanOrEqualTo(Integer minimumLevel) {
        return (((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("minimumLevel"), minimumLevel)));
    }

    public static Specification<Hench> hasLevelLessThanOrEqualTo(Integer maximumLevel) {
        return (((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("maximumLevel"), maximumLevel)));
    }
}
