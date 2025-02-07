package com.agenda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Aplica CORS a todas as rotas
                        .allowedOrigins("http://localhost:4200") // Permite requisições do front-end (React/Vue/Angular)
                        .allowedMethods("GET", "POST", "PUT", "PATCH","DELETE", "OPTIONS") // Métodos permitidos
                        .allowedHeaders("*") // Todos os headers permitidos
                        .allowCredentials(true); // Permite credenciais (cookies, autenticação)
            }
        };
    }
}
