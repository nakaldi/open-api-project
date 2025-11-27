package com.example.open_api_project.service;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberVO {

    private Long id;    //PK
    private String username;
    private String password;
    private String nickname;
    private String role;

    // 소셜 로그인용 컬럼
    private String provider;
    private String providerId;

    private LocalDateTime createdAt;
}
