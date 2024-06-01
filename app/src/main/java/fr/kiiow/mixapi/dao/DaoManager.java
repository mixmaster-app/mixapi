package fr.kiiow.mixapi.dao;

import fr.kiiow.mixapi.dao.Guild.IGuildDao;
import fr.kiiow.mixapi.dao.Hench.IHenchDao;
import fr.kiiow.mixapi.dao.User.IUserDao;
import fr.kiiow.mixapi.dao.World.IZoneDao;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Service
public class DaoManager {

    @Autowired
    private IZoneDao zoneDao;

    @Autowired
    private IHenchDao henchDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IGuildDao guildDao;
}
