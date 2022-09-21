package com.example.laptopsrestdatajpa.controllers;

import com.example.laptopsrestdatajpa.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Set up random port for testing purposes
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired //Asking Spring to inject the builder
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort //Port injected by Spring
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @DisplayName("Testing create method from Spring REST controllers")
    @Order(1)
    @Test
    void createTest() {
        //Indicate we want to get json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json= """
                {
                    "brand": "TestBrand",
                    "model": "TestModel",
                    "price": 19.99,
                    "memory": 8,
                    "sdd": false
                }                        
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);
        Laptop result = response.getBody();
        assertEquals(1L, result.getId());
        assertEquals("TestBrand", result.getBrand());
    }

    @DisplayName("Testing findAll method from Spring REST controllers")
    @Order(2)
    @Test
    void findAllTest() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());
    }

    @DisplayName("Testing findOneById method from Spring REST controllers")
    @Order(3)
    @Test
    void findOneByIdTest() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @DisplayName("Testing update method from Spring REST controllers")
    @Order(4)
    @Test
    void updateTest() {
        createTest();
        HttpHeaders headers2 = new HttpHeaders();
        headers2.setContentType(MediaType.APPLICATION_JSON);
        headers2.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json2= """
                {
                    "id": 1,
                    "brand": "TestBrandModified",
                    "model": "TestModelModified",
                    "price": 9.99,
                    "memory": 16,
                    "sdd": true
                }                      
                """;
        HttpEntity<String> request2 = new HttpEntity<>(json2, headers2);
        ResponseEntity<Laptop> response2 = testRestTemplate.exchange("/api/laptops", HttpMethod.PUT, request2, Laptop.class);
        Laptop result = response2.getBody();
        System.out.println("Esto es lo que sale: " + result.toString());
        assertEquals("TestBrandUpdated", result.getBrand());

    }

    @DisplayName("Testing delete method from Spring REST controllers")
    @Order(5)
    @Test
    void deleteTest() {
        ResponseEntity<Void> response = testRestTemplate.exchange("/api/laptops/1", HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @DisplayName("Testing deleteAll method from Spring REST controllers")
    @Order(6)
    @Test
    void deleteAllTest() {
        ResponseEntity<Void> response = testRestTemplate.exchange("/api/laptops", HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}