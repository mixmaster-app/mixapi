package fr.kiiow.mixapi.models.Hench;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kiiow.mixapi.models.World.Zone;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "hench")
public class Hench {

    @Id
    private Integer id;

    private String name;

    @Column(name = "img_url")
    @JsonProperty(value = "img_url")
    private String image;

    @Column(name = "minimum_level")
    @JsonProperty(value = "minimum_level")
    private Integer minimumLevel;

    @Column(name = "maximum_level")
    @JsonProperty(value = "maximum_level")
    private Integer maxiumLevel;

    @Column(name = "atk_type", columnDefinition = "TINYINT")
    @JsonProperty(value = "atk_type")
    private Integer attackType;

    @Column(name = "is_dropable")
    @JsonProperty(value = "is_dropable")
    private boolean isDropable;

    @Column(name = "is_mixable")
    @JsonProperty(value = "is_mixable")
    private boolean isMixable;

    @Column(name = "is_questable")
    @JsonProperty(value = "is_questable")
    private boolean isQuestable;

    @Embedded
    private HenchStats stats;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private HenchType type;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "hench_zone",
            joinColumns = @JoinColumn(name = "hench_id"),
            inverseJoinColumns = @JoinColumn(name = "zone_id")
    )
    private List<Zone> zones;

    @OneToMany(mappedBy = "henchResult")
    @JsonProperty(value = "mix")
    private List<HenchMix> mix;

    @OneToMany(mappedBy = "henchLeft")
    @JsonIgnore
    private List<HenchMix> evolutionsLeft;

    @OneToMany(mappedBy = "henchRight")
    @JsonIgnore
    private List<HenchMix> evolutionsRight;

    @JsonProperty(value = "evolutions")
    public List<HenchMix> getHenchEvolutions() {
        List<HenchMix> result = new ArrayList<>(evolutionsLeft);
        result.addAll(evolutionsRight);
        return result.stream().sorted(Comparator.comparingInt(HenchMix::getId)).toList();
    }
}
