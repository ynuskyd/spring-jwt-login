package com.akayk.keepin.service.impl;

import com.akayk.keepin.dto.JwtAuthResponse;
import com.akayk.keepin.dto.LoginDto;
import com.akayk.keepin.dto.RegisterDto;
import com.akayk.keepin.entity.User;
import com.akayk.keepin.repository.UserRepository;
import com.akayk.keepin.security.JwtTokenProvider;
import com.akayk.keepin.service.AuthService;
import lombok.AllArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String register(RegisterDto registerDto) {

        User newUser = new User();
        newUser.setUsername(registerDto.getUsername());
        newUser.setEmail(registerDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        userRepository.save(newUser);

        return "User created successfully.";
    }

    @Override
    public JwtAuthResponse login(LoginDto loginDto) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(),
                loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String authenticationToken = jwtTokenProvider.generateToken(authenticate);
        return new JwtAuthResponse(authenticationToken, loginDto.getUsername());
    }
}
