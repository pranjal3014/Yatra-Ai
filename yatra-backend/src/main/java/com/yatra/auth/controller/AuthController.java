package com.yatra.auth.controller;


import com.yatra.auth.dto.request.LoginRequest;
import com.yatra.auth.dto.request.RegisterRequest;
import com.yatra.auth.dto.response.AuthResponse;
import com.yatra.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody @Valid  LoginRequest request){
       return authService.login(request);
    }
    @PostMapping("/register")
    public AuthResponse register(@RequestBody @Valid RegisterRequest request){
        return authService.register(request);
    }
}
