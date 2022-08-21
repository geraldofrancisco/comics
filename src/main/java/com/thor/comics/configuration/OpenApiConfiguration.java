package com.thor.comics.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Comics API",
        version = "1.0.0",
        description = "Microservice for comic operations"
))
public class OpenApiConfiguration {
}
