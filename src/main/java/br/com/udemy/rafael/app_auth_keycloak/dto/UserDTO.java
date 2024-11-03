package br.com.udemy.rafael.app_auth_keycloak.dto;

public record UserDTO(String password, String clientId, String grantType, String username) {
}
