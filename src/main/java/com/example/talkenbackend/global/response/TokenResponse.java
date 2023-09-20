package com.example.talkenbackend.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PROTECTED)
public class TokenResponse<T> {

    private String accessToken;
    private Integer code;

    public TokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public TokenResponse(String accessToken, Integer code) {
        this.accessToken = accessToken;
        this.code = code;
    }

    public static <Void> TokenResponse<Void> response(String accessToken, Integer code) {
        return TokenResponse.<Void>builder()
                .accessToken(accessToken)
                .code(code)
                .build();
    }

}
