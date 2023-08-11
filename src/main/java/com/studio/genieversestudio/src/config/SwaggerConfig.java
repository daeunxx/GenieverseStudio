package com.studio.genieversestudio.src.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        Info info = new Info()
                .title("Genieverse Studio Genie Home")
                .description("Genieverse Studio Genie Home Creation based web")
                .version("v1.0.0");
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
