package com.dera.World.Banking;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "World Banking Application",
				description = "Backend REST APIs for World Banking Application",
				version = "v.1.0",
				contact = @Contact(
						name = "Chidera Uzoigwe",
						email = "chiderauzoigwe2@gmail.com",
						url = "https://github.com/Deraclassic"
				),
				license = @License(
						name = "World Banking Application",
						url = "https://github.com/Deraclassic"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Backend REST APIs for World Banking Application",
				url = "https://github.com/Deraclassic"
		)
)
public class WorldBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldBankingApplication.class, args);
	}

}
