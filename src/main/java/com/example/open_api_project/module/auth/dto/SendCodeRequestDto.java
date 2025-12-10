package com.example.open_api_project.module.auth.dto;

import com.example.open_api_project.common.validation.ValidEmail;
import lombok.Data;

@Data
public class SendCodeRequestDto {

    @ValidEmail
    private String email;
}
