package fr.kiiow.mixapi.models.hench;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.kiiow.mixapi.models.world.Item;
import fr.kiiow.mixapi.models.world.Zone;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "hench_loots")
public class HenchLoots {

    @EmbeddedId
    @JsonIgnore
    private HenchLoots_Key id;

    @ManyToOne
    @MapsId("henchId")
    @JoinColumn(name = "hench_id")
    @JsonIgnoreProperties({"zones"})
    private Hench hench;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    @JsonIgnoreProperties({"lootZoneAndHench"})
    private Item item;

    @ManyToOne
    @MapsId("zoneId")
    @JoinColumn(name = "zone_id")
    @JsonIgnoreProperties({"henchs"})
    private Zone zone;
}
