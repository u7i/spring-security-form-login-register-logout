package com.juxta.controller;

import com.juxta.config.jwt.JwtUtil;
import com.juxta.service.AuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/json")
@RequiredArgsConstructor
public class TestController {
    private final AuthenticationService authenticationService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/token")
    public String token(Authentication authentication) {
        return jwtUtil.generateToken(authentication);
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateTokenPage(@RequestParam String token) {
        return authenticationService.validateToken(token);
    }
}