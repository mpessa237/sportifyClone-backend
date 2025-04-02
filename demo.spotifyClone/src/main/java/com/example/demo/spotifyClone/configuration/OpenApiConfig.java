package com.example.demo.spotifyClone.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.nio.charset.StandardCharsets;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "HERVE MPESSA FOGANG",
                        email = "hervempessa7@gmail.com",
                        url = "https://herve.com"
                ),
                title = "SPOTIFY CLONE APIs",
                description = "Spotify Clone App APIs ",
                termsOfService = "&copy; HERVE",
                version = "v1"
        )
)
public class OpenApiConfig {
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        return converter;
    }
}
