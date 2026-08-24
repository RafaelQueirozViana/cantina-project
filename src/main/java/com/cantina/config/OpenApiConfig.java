package com.cantina.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI concessionariaOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sistema de Cantina")
                        .description("API para controle de lanches da cantina")
                        .version("1.0"));
    }
}