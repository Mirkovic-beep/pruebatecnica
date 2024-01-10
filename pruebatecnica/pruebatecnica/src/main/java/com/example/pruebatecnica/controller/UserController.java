package com.example.pruebatecnica.controller;

import com.example.pruebatecnica.security.TokenManager;
import com.example.pruebatecnica.service.UserService;
import com.example.pruebatecnica.util.FileGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FileGenerator fileGenerator;
    
    @Autowired
    private TokenManager tokenManager;

    @GetMapping("/api/users")
    public ResponseEntity<Resource> getUsersFile(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).build();
        }
        
        String token = authHeader.substring(7); 
        if (!tokenManager.validateToken(token)) {
            return ResponseEntity.status(401).build(); 
        }

        Resource file = fileGenerator.generateCsvFile(userService.getAllUsers());
        return ResponseEntity.ok()
            .header("Content-Disposition", "attachment; filename=users.csv")
            .body(file);
    }
}
