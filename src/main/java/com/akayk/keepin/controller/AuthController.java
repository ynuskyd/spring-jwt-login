package com.akayk.keepin.controller;

import com.akayk.keepin.dto.JwtAuthResponse;
import com.akayk.keepin.dto.LoginDto;
import com.akayk.keepin.dto.RegisterDto;
import com.akayk.keepin.repository.UserRepository;
import com.akayk.keepin.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {

        if (Boolean.TRUE.equals(userRepository.existsByUsername(registerDto.getUsername()))) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        if (Boolean.TRUE.equals(userRepository.existsByEmail(registerDto.getEmail()))) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        authService.register(registerDto);
        return ResponseEntity.ok("User created successfully.");
    }


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginDto loginDto) {
        try {
            JwtAuthResponse authResponse = authService.login(loginDto);
            return ResponseEntity.ok(authResponse);
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username/Password");
        }
    }
}
