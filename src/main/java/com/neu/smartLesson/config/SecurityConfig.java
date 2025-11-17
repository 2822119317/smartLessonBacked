package com.neu.smartLesson.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // 启用 @PreAuthorize 等方法级安全注解 (可选但推荐)
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter; // 我们的 JWT 过滤器

    @Autowired
    private AuthenticationProvider authenticationProvider; // 我们在 ApplicationConfig 中定义的 Bean

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. 禁用 CSRF (因为我们使用 JWT, API 是无状态的)
                .csrf(AbstractHttpConfigurer::disable)

                // 2. 定义 API 路径的访问权限
                .authorizeHttpRequests(auth -> auth
                        // 公开白名单: 登录接口, API文档(Swagger)
                        .requestMatchers(
                                "/auth/login",
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()

                        // 角色权限示例: 假设教师端 API (您可以根据需要调整)
                        .requestMatchers("/teacher/**").hasRole("teacher")
                        .requestMatchers("/student/**").hasRole("student")

                        // 其他所有请求都必须经过认证
                        .anyRequest().authenticated()
                )

                // 3. 设置 Session 管理为无状态 (STATELESS)
                // Spring Security 不会创建或使用 HttpSession
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // 4. 注册我们的 AuthenticationProvider
                .authenticationProvider(authenticationProvider)

                // 5. 【关键】将我们的 JWT 过滤器添加到 Spring Security 过滤器链中
                // 放在 UsernamePasswordAuthenticationFilter 之前
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}