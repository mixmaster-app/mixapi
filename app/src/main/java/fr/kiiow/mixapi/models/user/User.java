package fr.kiiow.mixapi.models.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.kiiow.mixapi.models.guild.Guild;
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
    @JoinTable(
            name = "guild_user",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "guild_id", referencedColumnName = "id")
    )
    @JsonIgnoreProperties({"users"})
    private Guild guild;
}
