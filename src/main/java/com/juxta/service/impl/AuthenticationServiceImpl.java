package com.juxta.service.impl;

import com.juxta.config.jwt.JwtUtil;
import com.juxta.service.AuthenticationService;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    public ResponseEntity<?> validateToken(@org.jetbrains.annotations.NotNull String token) {
        if (token.equals("") || token == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            try {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtUtil.getUsernameFromToken(token));
                Boolean isTokenValid = jwtUtil.validateToken(token, userDetails);
                return ResponseEntity.ok(isTokenValid);
            } catch (ExpiredJwtException e) {
                return ResponseEntity.ok(false);
            }
        }
    }
}