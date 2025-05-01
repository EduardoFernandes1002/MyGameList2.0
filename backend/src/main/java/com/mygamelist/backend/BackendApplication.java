package com.mygamelist.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackendApplication {

	// Método principal que inicia a aplicação Spring Boot
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	// Configuração do CORS para permitir requisições do frontend
	// Adiciona o CORS para permitir requisições do frontend (Angular) para o backend (Spring Boot)
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() { 

			// Configuração do CORS
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**") // Permite o acesso a todos os endpoints
                        .allowedOrigins("http://localhost:4200") // Permite o acesso apenas do frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite os métodos HTTP necessários
						.allowedHeaders("*") // Permite todos os headers
						.exposedHeaders("Authorization") // Expose apenas headers necessários
                        .allowCredentials(true) // Permite credenciais (cookies, autenticação HTTP, etc.)
                        .maxAge(3600); 
            }
        };
	}
}
