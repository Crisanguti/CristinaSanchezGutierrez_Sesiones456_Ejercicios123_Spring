package com.example.laptopsrestdatajpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

//Set up for Swagger documentation generation
@Configuration
public class SwaggerConfig {

    @Bean //We need to point that this is a bean for Spring
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Spring Boot Laptop API REST",
                "Library Api rest docs",
                "1.0",
                "http://www.google.es",
                new Contact("Cristina", "http://www.google.com", "cristina@example.com"),
                "MIT",
                "http://www.google.com",
                Collections.emptyList());
    }
}
