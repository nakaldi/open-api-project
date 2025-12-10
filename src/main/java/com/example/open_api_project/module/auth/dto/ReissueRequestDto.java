package com.example.open_api_project.module.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReissueRequestDto {

    @JsonProperty("refresh_token")
    private String refreshToken;
}
