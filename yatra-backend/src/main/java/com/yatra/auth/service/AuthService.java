package com.yatra.auth.service;

import com.yatra.auth.dto.request.LoginRequest;
import com.yatra.auth.dto.request.RegisterRequest;
import com.yatra.auth.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}
