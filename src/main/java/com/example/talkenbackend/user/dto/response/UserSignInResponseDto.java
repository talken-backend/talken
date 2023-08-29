package com.example.talkenbackend.user.dto.response;

import com.example.talkenbackend.user.domain.User;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserSignInResponseDto {
    private String email;

    @Column(nullable = false)
    private String username;
    private String profileImageUrl; // 프로필 사진 경로

    public static UserSignInResponseDto fromEntity(User user) {
        return UserSignInResponseDto.builder()
                .username(user.getUsername())
                .profileImageUrl(user.getProfileImageUrl())
                .email(user.getEmail())
                .build();
    }
}
