package fr.kiiow.mixapi.models.guild;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kiiow.mixapi.models.user.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(
        name = "guild_user",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "guild_id"})
)
public class GuildUser {

    @EmbeddedId
    @JsonIgnore
    private GuildUser_Key id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonProperty(value = "user")
    @JsonIgnoreProperties({"guild"})
    private User user;

    @ManyToOne
    @MapsId("guildId")
    @JoinColumn(name = "guild_id")
    @JsonProperty(value = "guild")
    @JsonIgnoreProperties({"users"})
    private Guild guild;

    @JsonProperty(value = "role")
    private String role;

}
