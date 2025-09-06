package com.example.CRUD.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CRUD Spring Boot API")
                        .version("1.0.0")
                        .description("API para registro y gestión de datos de personas. "+
                                "Esta API permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) "+
                                "sobre usuarios del sistema.")
                        .contact(new Contact()
                                .name("Desarrollador")
                                .email("contacto@example.com")
                                .url("https://github.com/aler06/CRUD-Spring-Boot"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
