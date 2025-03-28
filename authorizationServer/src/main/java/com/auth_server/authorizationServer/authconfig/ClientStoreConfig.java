package com.auth_server.authorizationServer.authconfig;

import com.auth_server.authorizationServer.entity.AuthClient;
import com.auth_server.authorizationServer.repository.ClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;

import java.util.Arrays;

@Configuration
public class ClientStoreConfig {

    @Bean
    RegisteredClientRepository registeredClientRepository(
            ClientRepository clientRepository,
            PasswordEncoder passwordEncoder) {

        return new RegisteredClientRepository() {
            @Override
            public void save(RegisteredClient registeredClient) {
            }

            @Override
            public RegisteredClient findById(String id) {
                return clientRepository.findById(Long.valueOf(id))
                        .map(this::mapToRegisteredClient)
                        .orElse(null);
            }

            @Override
            public RegisteredClient findByClientId(String clientId) {
                return clientRepository.findByClientId(clientId)
                        .map(this::mapToRegisteredClient)
                        .orElse(null);

            }

            private RegisteredClient mapToRegisteredClient(AuthClient client) {
                return RegisteredClient.withId(client.getId().toString())
                        .clientId(client.getClientId())
                        .clientSecret(client.getClientSecret())
                        .clientAuthenticationMethods(methods ->
                                Arrays.stream(client.getAuthenticationMethods().split(","))
                                        .map(String::trim)
                                        .map(ClientAuthenticationMethod::new)
                                        .forEach(methods::add))
                        .authorizationGrantTypes(types ->
                                Arrays.stream(client.getAuthorizationGrantTypes().split(","))
                                        .map(String::trim)
                                        .map(AuthorizationGrantType::new)
                                        .forEach(types::add))
                        .redirectUris(uris ->
                                Arrays.stream(client.getRedirectUris().split(","))
                                        .map(String::trim)
                                        .forEach(uri -> uris.add(uri.trim())))
                        .scopes(scopes ->
                                Arrays.stream(client.getScopes().split(","))
                                        .map(String::trim)
                                        .forEach(scopes::add))
                        .clientSettings(ClientSettings.builder()
                                .requireAuthorizationConsent(client.isRequireAuthorizationConsent())
                                .build())
                        .build();
            }
        };
    }
}