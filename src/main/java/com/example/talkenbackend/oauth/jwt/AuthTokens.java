package com.example.talkenbackend.oauth.jwt;

import com.example.talkenbackend.user.dto.response.UserSignInResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokens {
    private String accessToken;
    private String refreshToken;
    private String grantType;
    private Long expiresIn;

    private UserSignInResponseDto user;

    public static AuthTokens of(String accessToken, String refreshToken, String grantType, Long expiresIn, UserSignInResponseDto user) {
        return new AuthTokens(accessToken, refreshToken, grantType, expiresIn, user);
    }

    public void addUser(UserSignInResponseDto user) {
        this.user = user;
    }
}