package fr.kiiow.mixapi.models.hench;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kiiow.mixapi.models.world.Item;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(
        name = "hench_mix",
        uniqueConstraints = @UniqueConstraint(columnNames = {"hench_result_id", "item_left_id", "hench_left_id", "item_right_id", "hench_right_id"})
)
public class HenchMix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "hench_result_id")
    @JsonIgnoreProperties({"evolutions", "mix"})
    @JsonProperty(value = "hench_result")
    private Hench henchResult;

    @ManyToOne
    @JoinColumn(name = "item_left_id")
    @JsonProperty(value = "item_left")
    private Item itemLeft;

    @ManyToOne
    @JoinColumn(name = "hench_left_id")
    @JsonIgnoreProperties({"evolutions", "mix"})
    @JsonProperty(value = "hench_left")
    private Hench henchLeft;

    @ManyToOne
    @JoinColumn(name = "item_right_id")
    @JsonProperty(value = "item_right")
    private Item itemRight;

    @ManyToOne
    @JoinColumn(name = "hench_right_id")
    @JsonIgnoreProperties({"evolutions", "mix"})
    @JsonProperty(value = "hench_right")
    private Hench henchRight;
}
