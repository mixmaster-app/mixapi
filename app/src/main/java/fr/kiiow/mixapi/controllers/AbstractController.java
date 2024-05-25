package fr.kiiow.mixapi.controllers;

import fr.kiiow.mixapi.dao.DaoManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractController extends AbstractErrorResponseController {

    protected final Logger log = LogManager.getLogger();

    @Autowired
    private DaoManager daoManager;

    protected DaoManager getDaoManager() {
        return this.daoManager;
    }

    protected <T> ResponseEntity<T> resultOk(T response) {
        return new ResponseEntity<T>(response, HttpStatus.OK);
    }
}
