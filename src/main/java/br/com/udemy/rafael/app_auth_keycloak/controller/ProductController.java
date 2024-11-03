package br.com.udemy.rafael.app_auth_keycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping(value = "/")
    public String listProducts() {
        return "Product list";
    }

    @PostMapping(value = "/")
    public String createProduct() {
        return "Product create";
    }
}
