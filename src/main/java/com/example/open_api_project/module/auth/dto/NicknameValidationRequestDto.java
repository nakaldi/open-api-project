package com.example.open_api_project.module.auth.dto;

import com.example.open_api_project.common.validation.ValidNickname;
import lombok.Data;

@Data
public class NicknameValidationRequestDto {

    @ValidNickname
    String nickname;
}
