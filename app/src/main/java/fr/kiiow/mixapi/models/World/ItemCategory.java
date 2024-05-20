package fr.kiiow.mixapi.models.World;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item_category")
public class ItemCategory {

    @Id
    private Integer id;

    private String name;
}
