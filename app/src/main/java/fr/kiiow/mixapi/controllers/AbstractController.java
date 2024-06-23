package fr.kiiow.mixapi.controllers;

import fr.kiiow.mixapi.dao.DaoManager;
import fr.kiiow.mixapi.models.config.Config;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public abstract class AbstractController extends ErrorResponseController {

    protected final Logger log = LogManager.getLogger();

    @Autowired
    private DaoManager daoManager;

    @Autowired
    private Config config;

    protected <T> ResponseEntity<T> resultOk(T response) {
        return new ResponseEntity<T>(response, HttpStatus.OK);
    }
}
