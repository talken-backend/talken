package com.example.talkenbackend.user.dto.response;

import com.example.talkenbackend.user.domain.User;
import com.example.talkenbackend.user.domain.UserRole;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponseDto {
    private Long id;
    private String email;
    private String username;
    private UserRole role;

    public static UserResponseDto fromEntity(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }
}
