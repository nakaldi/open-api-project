package com.example.open_api_project.module.member.dto;

import com.example.open_api_project.common.validation.ValidPassword;
import lombok.Getter;

@Getter
public class PasswordVerificationRequestDto {

    @ValidPassword
    String currentPassword;
}
