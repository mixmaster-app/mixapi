package fr.kiiow.mixapi.models.Hench;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.kiiow.mixapi.models.World.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "hench_mix")
public class HenchMix {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "hench_result_id")
    @JsonIgnoreProperties({"evolutions", "mix"})
    private Hench henchResult;

    @ManyToOne
    @JoinColumn(name = "item_left_id")
    private Item itemLeft;

    @ManyToOne
    @JoinColumn(name = "hench_left_id")
    @JsonIgnoreProperties({"evolutions", "mix"})
    private Hench henchLeft;

    @ManyToOne
    @JoinColumn(name = "item_right_id")
    private Item itemRight;

    @ManyToOne
    @JoinColumn(name = "hench_right_id")
    @JsonIgnoreProperties({"evolutions", "mix"})
    private Hench henchRight;
}
