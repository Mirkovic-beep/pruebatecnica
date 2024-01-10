package com.example.pruebatecnica.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.pruebatecnica.repository.UserRepository;
import com.example.pruebatecnica.model.User; // Importar la clase User si no está importada

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        try {
            userRepository.save(new User("Thomson, Elias", "555-8596", "Diamond St. 4G3 NY", "password1"));
            userRepository.save(new User("Simond, Ella", "415-9687", "Fleet st. 45 B, 56 BR-NY", "password2"));
            userRepository.save(new User("Clifford, Thomas", "416-69883", "Meet town, 45 - FL", "password3"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}