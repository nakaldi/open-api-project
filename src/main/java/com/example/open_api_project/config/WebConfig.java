package com.example.open_api_project.config;

import com.example.open_api_project.common.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
            .order(1)
            .addPathPatterns("/**") // 기본적으로 다 막음
            .excludePathPatterns(
                "/", "/login", "/join",
                "/api/login", "/api/join",
                "/css/**", "/js/**", "/error", "/favicon.ico",

                "/board/**",      // 게시판 화면
                "/api/boards/**"  // 게시판 데이터
            );
    }
}