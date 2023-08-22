package com.example.talkenbackend.user.dto;

import com.example.talkenbackend.user.domain.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponseDto {
    private Long id;
    private String email;
    private String username;
    private String phone;
    private String introCaption;
    private String category;
    private String position;
    private String profilePath;

    public static UserResponseDto fromEntity(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .phone(user.getPhone())
                .phone(user.getIntroCaption())
                .phone(user.getCategory())
                .phone(user.getPosition())
                .phone(user.getProfilePath())
                .build();
    }
}
