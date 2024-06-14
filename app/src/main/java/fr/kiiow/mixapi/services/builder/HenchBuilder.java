package fr.kiiow.mixapi.services.builder;

import fr.kiiow.mixapi.models.hench.Hench;

public class HenchBuilder {

    public static Hench createDefaultHench(Integer id) {
        Hench hench = new Hench();
        hench.setId(id);
        return hench;
    }
}
