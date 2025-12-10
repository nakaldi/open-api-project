package com.example.open_api_project.module.auth.dto;

import com.example.open_api_project.common.validation.ValidEmail;
import com.example.open_api_project.common.validation.ValidPassword;
import lombok.Data;

@Data
public class LoginRequestDto {

    @ValidEmail
    private String email;

    @ValidPassword
    private String password;
}
