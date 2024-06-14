package fr.kiiow.mixapi.models.guild;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "guild")
public class Guild {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "guild")
    @JsonProperty(value = "users")
    @JsonIgnoreProperties({"guild"})
    private List<GuildUser> users;

    public Guild() { }

    public Guild(Integer id) {
        this.id = id;
    }
}
