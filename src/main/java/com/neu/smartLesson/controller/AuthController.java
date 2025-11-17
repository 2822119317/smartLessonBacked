package com.neu.smartLesson.controller;

import com.neu.smartLesson.dto.LoginRequest;
import com.neu.smartLesson.dto.LoginResponse;
import com.neu.smartLesson.service.AuthService; // 注入接口
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth") // 对应 SecurityConfig 中的 /auth/**
public class AuthController {

    @Autowired
    private AuthService authService; // 注入接口 (Spring 会自动找到实现类)

    /**
     * POST /auth/login
     * 用户登录接口 (US01, US02)
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        // 调用 Service 层处理登录
        LoginResponse response = authService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
}