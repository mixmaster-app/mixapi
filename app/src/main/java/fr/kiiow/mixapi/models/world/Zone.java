package fr.kiiow.mixapi.models.world;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "zone")
public class Zone {

    @Id
    private Integer id;

    private String name;
}
