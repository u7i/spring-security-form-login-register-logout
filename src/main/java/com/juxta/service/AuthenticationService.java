package com.juxta.service;

import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<?> validateToken(String token);
}