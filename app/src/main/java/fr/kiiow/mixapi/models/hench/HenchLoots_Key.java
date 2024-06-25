package fr.kiiow.mixapi.models.hench;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class HenchLoots_Key implements Serializable {

    @Column(name = "hench_id")
    private Integer henchId;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "zone_id")
    private Integer zoneId;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
