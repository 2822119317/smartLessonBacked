package com.neu.smartLesson.service.impl;


import com.neu.smartLesson.dto.AuthUserDto;
import com.neu.smartLesson.dto.LoginRequest;
import com.neu.smartLesson.dto.LoginResponse;
import com.neu.smartLesson.mapper.AuthMapper;
import com.neu.smartLesson.model.User;
import com.neu.smartLesson.service.AuthService; // 引用接口
import com.neu.smartLesson.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service // 声明为 Service Bean
public class AuthServiceImpl implements AuthService { // 实现接口

    @Autowired
    private AuthenticationManager authenticationManager; // 现在可以正确注入了

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthMapper authMapper;

    @Override // 必须实现接口方法
    public LoginResponse login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = (User) authentication.getPrincipal();
        String token = jwtUtil.generateToken(user);
        AuthUserDto userDto = authMapper.toAuthUserDto(user);

        return new LoginResponse(token, userDto);
    }
}