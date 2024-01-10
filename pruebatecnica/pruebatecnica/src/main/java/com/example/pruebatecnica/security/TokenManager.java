package com.example.pruebatecnica.security;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class TokenManager {
    private final Set<String> activeTokens = Collections.synchronizedSet(new HashSet<>());

    public void addToken(String token) {
        try {
            activeTokens.add(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validateToken(String token) {
        try {
            return activeTokens.stream().anyMatch(activeToken -> activeToken.equals(token));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void cleanupInactiveTokens(Set<String> inactiveTokens) {
        try {
            activeTokens.removeAll(inactiveTokens.stream()
                    .filter(inactiveToken -> !validateToken(inactiveToken))
                    .collect(Collectors.toSet()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}