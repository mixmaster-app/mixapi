package fr.kiiow.mixapi.models.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultResponse {

    private String message;

    public DefaultResponse(String message) {
        this.message = message;
    }
}
