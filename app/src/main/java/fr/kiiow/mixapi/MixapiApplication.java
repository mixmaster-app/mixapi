package fr.kiiow.mixapi;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MixapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MixapiApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
        return new OpenAPI()
				.components(new Components())
				.info(
						new Info()
								.title("Mixmaster API")
								.description("Unofficial mixmaster API")
								.version("2.0")
				);
	}

}
