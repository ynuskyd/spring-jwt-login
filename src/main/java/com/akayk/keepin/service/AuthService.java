package com.akayk.keepin.service;


import com.akayk.keepin.dto.JwtAuthResponse;
import com.akayk.keepin.dto.LoginDto;
import com.akayk.keepin.dto.RegisterDto;

public interface AuthService {

    String register(RegisterDto registerDto);

    JwtAuthResponse login(LoginDto loginDto);
}
