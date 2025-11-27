package com.example.open_api_project.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor()) // 우리가 만든 검문소 등록
            .order(1) // 적용 순서 (1번)
            .addPathPatterns("/**") // 일단 모든 경로를 다 막아버림
            .excludePathPatterns(   // 검문 면제 구역 설정
                "/",            // 메인 페이지
                "/login",       // 로그인 화면
                "/join",        // 회원가입 화면
                "/api/login",   // 로그인 API (이거 막으면 로그인 못 함!)
                "/api/join",    // 회원가입 API
                "/css/**",      // 스타일시트
                "/js/**",       // 자바스크립트
                "/images/**",   // 이미지
                "/favicon.ico", // 아이콘
                "/error"        // 에러 페이지
            );
    }
}