package br.com.udemy.rafael.app_auth_keycloak.service.impl;

import br.com.udemy.rafael.app_auth_keycloak.dto.UserDTO;
import br.com.udemy.rafael.app_auth_keycloak.service.AuthService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String token(UserDTO dto) {

        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", dto.clientId());
        formData.add("username", dto.username());
        formData.add("password", dto.password());
        formData.add("grant_type", dto.grantType());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);
        var result = restTemplate.postForEntity(
                "http://127.0.0.1:8080/realms/poc-keycloak/protocol/openid-connect/token",
                request,
                String.class
        );

        return result.getBody();
    }
}
