package fr.kiiow.mixapi.models.hench;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kiiow.mixapi.models.world.Zone;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(
        name = "hench_zone",
        uniqueConstraints = @UniqueConstraint(columnNames = { "hench_id", "zone_id" })
)
public class HenchZone {

    @EmbeddedId
    @JsonIgnore
    private HenchZone_Key id;

    @ManyToOne
    @MapsId("henchId")
    @JoinColumn(name = "hench_id")
    @JsonProperty(value = "hench")
    @JsonIgnoreProperties({"zones"})
    private Hench hench;

    @ManyToOne
    @MapsId("zoneId")
    @JoinColumn(name = "zone_id")
    @JsonProperty(value = "zone")
    @JsonIgnoreProperties({"henchs"})
    private Zone zone;
}
