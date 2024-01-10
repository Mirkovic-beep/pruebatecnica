package com.example.pruebatecnica.controller;

import com.example.pruebatecnica.security.TokenManager;
import com.example.pruebatecnica.service.AuthenticationService;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private TokenManager tokenManager;

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody UserCredentials credentials) {
        String token = authenticationService.authenticate(credentials.getFullname(), credentials.getPassword());
        if (token != null) {
            tokenManager.addToken(token);
            return ResponseEntity.ok().body(Collections.singletonMap("Token", token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
    }

    static class UserCredentials {
        private String fullname;
        private String password;
        
		public String getFullname() {
			return fullname;
		}
		public String getPassword() {
			return password;
		}
    }
}
