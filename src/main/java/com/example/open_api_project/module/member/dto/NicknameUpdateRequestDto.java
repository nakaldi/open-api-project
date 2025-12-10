package com.example.open_api_project.module.member.dto;

import com.example.open_api_project.common.validation.ValidNickname;
import lombok.Getter;

@Getter
public class NicknameUpdateRequestDto {

    @ValidNickname
    private String nickname;
}
