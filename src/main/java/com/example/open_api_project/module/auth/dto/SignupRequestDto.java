package com.example.open_api_project.module.auth.dto;

import com.example.open_api_project.common.validation.ValidAuthKey;
import com.example.open_api_project.common.validation.ValidEmail;
import com.example.open_api_project.common.validation.ValidNickname;
import com.example.open_api_project.common.validation.ValidPassword;
import jakarta.validation.constraints.AssertTrue;
import lombok.Data;

@Data
public class SignupRequestDto {

    @AssertTrue(message = "서비스 이용약관에 동의해야 합니다.")
    private boolean termsOfServiceAgreed;

    @AssertTrue(message = "개인정보 처리방침에 동의해야 합니다.")
    private boolean privacyPolicyAgreed;

    @ValidEmail
    private String email;

    @ValidAuthKey
    private String authKey;

    @ValidNickname
    private String nickname;

    @ValidPassword
    private String password;

}
