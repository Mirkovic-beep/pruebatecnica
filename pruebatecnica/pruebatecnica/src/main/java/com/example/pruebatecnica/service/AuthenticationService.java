package com.example.pruebatecnica.service;

import com.example.pruebatecnica.model.User;
import com.example.pruebatecnica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public String authenticate(String fullname, String password) {
        User user = userRepository.findByFullname(fullname);
        if (user != null && user.getPassword().equals(password)) {
            return UUID.randomUUID().toString();
        }
        return null;
    }
}

