package fr.kiiow.mixapi.models.world;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kiiow.mixapi.models.hench.Hench;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "zone")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "hench_zone",
            joinColumns = @JoinColumn(name = "zone_id"),
            inverseJoinColumns = @JoinColumn(name = "hench_id")
    )
    @JsonProperty(value = "henchs")
    @JsonIgnoreProperties({"zones", "mix", "evolutions", "stats", "atk_type", "drop_rate", "is_questable", "minimum_level", "maximum_level"})
    private List<Hench> henchs;
}
