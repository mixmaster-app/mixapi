package fr.kiiow.mixapi.models.world;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kiiow.mixapi.models.hench.HenchLoots;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "item_category_id")
    private ItemCategory itemCategory;

    @OneToMany(mappedBy = "item")
    @JsonProperty(value = "loot_zone_and_hench")
    @JsonIgnoreProperties({"item"})
    private List<HenchLoots> lootZoneAndHench;
}
