package br.com.udemy.rafael.app_auth_keycloak.service;

import br.com.udemy.rafael.app_auth_keycloak.dto.UserDTO;

public interface AuthService {

    String token(UserDTO user);
}
