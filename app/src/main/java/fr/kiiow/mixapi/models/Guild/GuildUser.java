package fr.kiiow.mixapi.models.Guild;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fr.kiiow.mixapi.models.User.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "guild_user")
public class GuildUser {

    @EmbeddedId
    private GuildUserKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("guildId")
    @JoinColumn(name = "guild_id")
    @JsonBackReference
    private Guild guild;

    private String role;

}
