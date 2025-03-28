package com.auth_server.authorizationServer.repository;

import com.auth_server.authorizationServer.entity.AuthClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<AuthClient, Long> {
    Optional<AuthClient> findByClientId(String clientId);
}