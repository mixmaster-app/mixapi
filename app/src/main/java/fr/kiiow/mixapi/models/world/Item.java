package fr.kiiow.mixapi.models.world;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {

    @Id
    private Integer id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "item_category_id")
    private ItemCategory itemCategory;
}
