package fr.kiiow.mixapi.models.guild;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class GuildUserKey implements Serializable {

    @Column(name = "guild_id")
    private Integer guildId;

    @Column(name = "user_id")
    private Integer userId;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
