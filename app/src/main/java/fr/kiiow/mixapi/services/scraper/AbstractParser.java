package fr.kiiow.mixapi.services.scraper;

import fr.kiiow.mixapi.dao.DaoManager;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.nodes.Document;

@Getter
public abstract class AbstractParser {

    protected final Logger log = LogManager.getLogger();

    protected final Document pageToParse;

    protected final DaoManager daoManager;

    public AbstractParser(Document pageToParse, DaoManager daoManager) {
        this.pageToParse = pageToParse;
        this.daoManager = daoManager;
    }
}
