package br.com.udemy.rafael.app_auth_keycloak.auth;

import br.com.udemy.rafael.app_auth_keycloak.dto.UserDTO;
import br.com.udemy.rafael.app_auth_keycloak.service.impl.AuthServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final AuthServiceImpl authService;

    @Autowired
    public AuthController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/token")
    public ResponseEntity<String> token(@RequestBody UserDTO user) {
        log.info("Authentication Token to: {}", user.clientId());
        return ResponseEntity.ok(this.authService.token(user));
    }

}
