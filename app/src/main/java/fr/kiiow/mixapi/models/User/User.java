package fr.kiiow.mixapi.models.User;

import fr.kiiow.mixapi.models.Guild.GuildUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "level")
    private Integer level;

    @Column(name = "percent")
    private Float levelPercent;

    @ManyToOne
    @JoinColumn(name = "character_type_id")
    private CharacterType characterType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private GuildUser guild;
}
