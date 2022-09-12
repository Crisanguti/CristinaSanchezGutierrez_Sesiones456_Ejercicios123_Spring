package com.example.laptopsrestdatajpa.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;

import static org.junit.jupiter.api.Assertions.*;

//Set up random port for testing purposes
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @DisplayName("Testing findAll method from Spring REST controllers")
    @Test
    void findAll() {
    }

    @DisplayName("Testing findOneById method from Spring REST controllers")
    @Test
    void findOneById() {
    }

    @DisplayName("Testing create method from Spring REST controllers")
    @Test
    void create() {
    }

    @DisplayName("Testing update method from Spring REST controllers")
    @Test
    void update() {
    }

    @DisplayName("Testing delete method from Spring REST controllers")
    @Test
    void delete() {
    }

    @DisplayName("Testing deleteAll method from Spring REST controllers")
    @Test
    void deleteAll() {
    }
}