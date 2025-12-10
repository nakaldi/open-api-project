package com.example.open_api_project.module.auth.dto;

import com.example.open_api_project.common.validation.ValidAuthKey;
import com.example.open_api_project.common.validation.ValidEmail;
import com.example.open_api_project.common.validation.ValidPassword;
import lombok.Data;

@Data
public class ResetPasswordRequestDto {

    @ValidEmail
    private String email;

    @ValidAuthKey
    private String authKey;

    @ValidPassword
    private String password;
}
