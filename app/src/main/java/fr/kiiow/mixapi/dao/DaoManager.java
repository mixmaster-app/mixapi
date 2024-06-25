package fr.kiiow.mixapi.dao;

import fr.kiiow.mixapi.dao.guild.IGuildDao;
import fr.kiiow.mixapi.dao.hench.*;
import fr.kiiow.mixapi.dao.security.IAuthenticationUserDao;
import fr.kiiow.mixapi.dao.user.ICharacterTypeDao;
import fr.kiiow.mixapi.dao.user.IUserDao;
import fr.kiiow.mixapi.dao.user.IUserHenchDao;
import fr.kiiow.mixapi.dao.user.IUserItemDao;
import fr.kiiow.mixapi.dao.world.IItemDao;
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
    private IItemDao itemDao;

    @Autowired
    private IHenchDao henchDao;

    @Autowired
    private IHenchGenderDao henchGenderDao;

    @Autowired
    private IHenchNatureDao henchNatureDao;

    @Autowired
    private IHenchMixDao henchMixDao;

    @Autowired
    private IHenchTypeDao henchTypeDao;

    @Autowired
    private IHenchLootsDao henchLootsDao;

    @Autowired
    private IHenchZoneDao henchZoneDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private ICharacterTypeDao characterTypeDao;

    @Autowired
    private IUserHenchDao userHenchDao;

    @Autowired
    private IUserItemDao userItemDao;

    @Autowired
    private IGuildDao guildDao;

    @Autowired
    private IAuthenticationUserDao authenticationUserDao;
}
