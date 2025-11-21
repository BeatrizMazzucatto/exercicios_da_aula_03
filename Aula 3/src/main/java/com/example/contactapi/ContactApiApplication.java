package com.example.contactapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação Spring Boot
 * API REST para gerenciar lista de contatos
 */
@SpringBootApplication
public class ContactApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactApiApplication.class, args);
    }
}

