package com.sisal.user_services.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sisal.user_services.dto.LoginDTO;
import com.sisal.user_services.service.AuthenticationService;

import jakarta.validation.Valid;

/**
 *
 * @author senturke
 */
@RestController
@RequestMapping("/login")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO loginDTO) {
        try {
            String token = authenticationService.authenticateUser(loginDTO);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Authentication failed: " + e.getMessage());
        }
    }
}
