package fr.kiiow.mixapi.models.hench;

import lombok.Getter;

@Getter
public enum AttackType {
    CORPS_A_CORPS(1),
    DISTANCE(2),
    UNKNOWN(0);

    private final Integer type;

    AttackType(Integer type) {
        this.type = type;
    }

    public static AttackType findByText(String typeName) {
        return switch(typeName.toUpperCase()) {
            case "CORPS À CORPS" -> CORPS_A_CORPS;
            case "A DISTANCE", "DISTANCE" -> DISTANCE;
            default -> UNKNOWN;
        };
    }
}
