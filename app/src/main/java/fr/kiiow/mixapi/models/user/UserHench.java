package fr.kiiow.mixapi.models.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.kiiow.mixapi.models.hench.Hench;
import fr.kiiow.mixapi.models.hench.HenchGender;
import fr.kiiow.mixapi.models.hench.HenchNature;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_hench")
public class UserHench {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"userHenchs"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "hench_id")
    @JsonProperty(value = "hench")
    private Hench hench;

    @Column(name = "level")
    @JsonProperty(value = "level")
    private Integer level;

    @Column(name = "maximum_level")
    @JsonProperty(value = "maximum_level")
    private Integer maxLevel;

    @ManyToOne
    @JoinColumn(name = "hench_nature_id")
    @JsonProperty(value = "nature")
    private HenchNature henchNature;

    @ManyToOne
    @JoinColumn(name = "hench_gender_id")
    @JsonProperty(value = "gender")
    private HenchGender henchGender;
}
