//package com.auth_server.authorizationServer.controller;
//
//import com.auth_server.authorizationServer.service.JpaRegisteredClientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/clients")
//public class RegisteredClientController {
//
//    @Autowired
//    private JpaRegisteredClientRepository clientRepository; // Serviço que você já implementou
//
//    @PostMapping
//    public ResponseEntity<String> saveRegisteredClient(@RequestBody RegisteredClient registeredClient) {
//        try {
//            clientRepository.save(registeredClient);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Client saved successfully.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving client: " + e.getMessage());
//        }
//    }
//}