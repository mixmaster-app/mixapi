package fr.kiiow.mixapi.models.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties(prefix = "mixapi")
@Configuration
public class Config {

    private MixmasterConfig mixmaster;
}
