package fr.kiiow.mixapi.dao;

import fr.kiiow.mixapi.dao.World.IZoneDao;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Service
public class DaoManager {

    @Autowired
    private IZoneDao zoneDao;
}
