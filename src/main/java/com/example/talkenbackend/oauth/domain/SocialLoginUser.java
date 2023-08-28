package com.example.talkenbackend.oauth.domain;

import com.example.talkenbackend.oauth.dto.enums.OAuthProvider;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class SocialLoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nickname;
    private String name;
    private String thumbnailImageUrl;
    private String profileImageUrl;
    private String isDefaultImage;
    private String gender;
    private String phoneNumber;
    @Enumerated(value = EnumType.STRING)
    private OAuthProvider oAuthProvider;

    @Builder
    public SocialLoginUser(String email, String nickname, String thumbnailImageUrl,
                           String profileImageUrl,
                           String isDefaultImage,
                           String gender, String name,
                           String phoneNumber,
                           OAuthProvider oAuthProvider) {
        this.email = email;
        this.nickname = nickname;
        this.thumbnailImageUrl = thumbnailImageUrl;
        this.profileImageUrl = profileImageUrl;
        this.isDefaultImage = isDefaultImage;
        this.gender = gender;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.oAuthProvider = oAuthProvider;
    }
}