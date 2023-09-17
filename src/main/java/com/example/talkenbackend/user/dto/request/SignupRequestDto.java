package com.example.talkenbackend.user.dto.request;

import com.example.talkenbackend.user.domain.User;
import com.example.talkenbackend.user.domain.UserAuthority;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupRequestDto {

    private String email;
    private String username;
    private String password;
    private String passwordCheck;
    private String phone;

    @Builder
    public SignupRequestDto(String email, String username, String password, String passwordCheck, String phone) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.phone = phone;
    }

    public User toEntity(String password, UserAuthority authority) {
        return User.builder()
                .email(email)
                .username(username)
                .password(password)
                .passwordCheck(passwordCheck)
                .phone(phone)
                .authority(authority)
                .build();
    }
}
