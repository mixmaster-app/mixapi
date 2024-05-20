package fr.kiiow.mixapi.controllers;

import fr.kiiow.mixapi.dao.DaoManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController {

    protected final Logger log = LogManager.getLogger();

    @Autowired
    private DaoManager daoManager;

    protected DaoManager getDaoManager() {
        return this.daoManager;
    }
}
