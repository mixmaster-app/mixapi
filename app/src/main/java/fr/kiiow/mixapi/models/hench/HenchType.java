package fr.kiiow.mixapi.models.hench;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hench_type")
public class HenchType {

    @Id
    private Integer id;

    private String name;
}
