package fr.kiiow.mixapi.models.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kiiow.mixapi.models.guild.Guild;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "level")
    private Integer level;

    @Column(name = "percent")
    @JsonProperty(value = "level_percent")
    private Float levelPercent;

    @ManyToOne
    @JoinColumn(name = "character_type_id")
    @JsonProperty(value = "character_type")
    private CharacterType characterType;

    @ManyToOne
    @JoinTable(
            name = "guild_user",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "guild_id", referencedColumnName = "id")
    )
    @JsonIgnoreProperties({"users"})
    private Guild guild;

    @OneToMany(mappedBy = "user")
    @JsonProperty(value = "henchs")
    @JsonIgnoreProperties({"user"})
    private List<UserHench> henchs;

    @OneToMany(mappedBy = "user")
    @JsonProperty(value = "items")
    @JsonIgnoreProperties({"user"})
    private List<UserItem> items;

    @Column(name = "last_updated_at")
    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt;

    public boolean isGuilded() {
        return guild != null;
    }
}
