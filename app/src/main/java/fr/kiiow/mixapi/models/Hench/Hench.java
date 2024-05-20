package fr.kiiow.mixapi.models.Hench;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}
