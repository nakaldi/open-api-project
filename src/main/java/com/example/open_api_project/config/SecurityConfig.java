package com.example.open_api_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 암호화 도구 등록 - 시큐리티를 쓴 이유
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // CSRF 보안 끄기 (API 통신을 위해 비활성화)
            .csrf(AbstractHttpConfigurer::disable)
            // 기본 로그인 페이지 끄기
            .formLogin(AbstractHttpConfigurer::disable)
            // HTTP Basic 인증 끄기 (브라우저 팝업 인증창 안 뜨게)
            .httpBasic(AbstractHttpConfigurer::disable)
            // 어떤 주소로 들어오든 시큐리티는 막지 마라. 검사는 Interceptor가 할 것임
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            );

        return http.build();
    }
}