package com.example.dashboard;


import org.springframework.context.annotation.Configuration; // Importing Configuration annotation from Spring framework
import org.springframework.web.servlet.config.annotation.CorsRegistry; // Importing CorsRegistry class from Spring Web framework
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; // Importing WebMvcConfigurer interface from Spring Web framework

@Configuration // provides configuration to the Spring application context
public class CorsConfig implements WebMvcConfigurer { // Class declaration for CorsConfig implementing WebMvcConfigurer interface

    @Override 
    public void addCorsMappings(CorsRegistry registry) { // configure Cross-Origin Resource Sharing (CORS)
        registry.addMapping("/**") // Configuring CORS for all endpoints
                .allowedOrigins("*") // Allowing requests from any origin
                .allowedMethods("GET") // Allowing specified HTTP methods
                .allowedHeaders("*"); // Allowing all headers in HTTP requests
    }
}
