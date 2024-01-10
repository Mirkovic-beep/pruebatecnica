package com.example.pruebatecnica.repository;

import com.example.pruebatecnica.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByFullname(String fullname);
}

