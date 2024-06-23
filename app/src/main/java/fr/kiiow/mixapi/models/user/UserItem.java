package fr.kiiow.mixapi.models.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kiiow.mixapi.models.world.Item;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_item")
public class UserItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"items"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonProperty(value = "item")
    private Item item;

    @Column(name = "quantity")
    @JsonProperty(value = "quantity")
    private Integer quantity;

    @Column(name = "description")
    @JsonProperty(value = "description")
    private String description;

}
