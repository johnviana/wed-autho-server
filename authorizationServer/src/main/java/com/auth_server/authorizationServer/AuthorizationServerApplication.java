package com.auth_server.authorizationServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AuthorizationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServerApplication.class, args);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "admin";
		String storedHash = "$2a$10$v3Kz8eZ8EflidLICsSuvPeP5GmJQfqFRmkwHNtoIsD0uvZS44NEQm";

		boolean isValid = encoder.matches(rawPassword, storedHash);
		System.out.println("Senha válida? " + isValid);
	}

}
