package com.soa.canete.transaccional_allocation_soa_canete.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Configuration
public class WebClientCustomConfig {

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder()
                .baseUrl("https:/api/transaccionalData") // Reemplaza con la URL de la API que deseas consumir
                .defaultHeader("Authorization", "Bearer yourAccessToken"); // Agrega encabezados necesarios
    }
}
