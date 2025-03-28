//package com.auth_server.authorizationServer.controller;
//
//import com.auth_server.authorizationServer.service.JpaRegisteredClientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class LoginController {
//
//    @Autowired
//    private JpaRegisteredClientRepository registeredClientRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public boolean verifyClientSecret(String providedSecret, String storedSecret) {
//        return passwordEncoder.matches(providedSecret, storedSecret);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> authenticate(@RequestParam String clientId, @RequestParam String clientSecret) {
//        RegisteredClient client = registeredClientRepository.findByClientId(clientId);
//        if (client != null && passwordEncoder.matches(clientSecret, client.getClientSecret())) {
//            return ResponseEntity.ok("Autenticação bem-sucedida!");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
//        }
//    }
//}