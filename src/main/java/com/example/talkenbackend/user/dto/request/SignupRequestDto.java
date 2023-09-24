package com.example.talkenbackend.user.dto.request;

import com.example.talkenbackend.user.domain.User;
import com.example.talkenbackend.user.domain.UserAuthority;
import com.example.talkenbackend.user.domain.UserRole;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupRequestDto {

    private String email;
    private String username;
    private String password;
    private UserRole role;

    public User toEntity(String password, UserAuthority authority) {
        return User.builder()
                .email(email)
                .username(username)
                .password(password)
                .authority(authority)
                .role(role)
                .build();
    }
}
