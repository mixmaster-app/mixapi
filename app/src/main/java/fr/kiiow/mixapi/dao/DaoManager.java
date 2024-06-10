package fr.kiiow.mixapi.dao;

import fr.kiiow.mixapi.dao.guild.IGuildDao;
import fr.kiiow.mixapi.dao.hench.IHenchDao;
import fr.kiiow.mixapi.dao.hench.IHenchTypeDao;
import fr.kiiow.mixapi.dao.security.IAuthenticationUserDao;
import fr.kiiow.mixapi.dao.user.IUserDao;
import fr.kiiow.mixapi.dao.world.IZoneDao;
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
    private IHenchTypeDao henchTypeDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IGuildDao guildDao;

    @Autowired
    private IAuthenticationUserDao authenticationUserDao;
}
