package com.adoptme.petshop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Adoptme API",
                version = "1.0",
                description = "CRUD of pets and users"
        )
)
public class OpenApiConfig {
}
