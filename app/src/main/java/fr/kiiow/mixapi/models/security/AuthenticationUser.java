package fr.kiiow.mixapi.models.security;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "authentication_user")
public class AuthenticationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(name = "username")
    private String username;

    @Getter
    @Setter
    @JsonIgnore
    @Column(name = "password")
    private String password;

    public AuthenticationUser() { }
}
