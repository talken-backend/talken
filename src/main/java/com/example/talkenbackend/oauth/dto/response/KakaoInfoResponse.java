package com.example.talkenbackend.oauth.dto.response;

import com.example.talkenbackend.oauth.domain.SocialLoginUser;
import com.example.talkenbackend.oauth.dto.enums.OAuthProvider;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoInfoResponse implements OAuthInfoResponse {

    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;

    public SocialLoginUser toEntity() {
        return SocialLoginUser.builder()
                .email(this.getEmail())
                .nickname(this.getNickname())
                .thumbnailImageUrl(this.getThumbnailImageUrl())
                .oAuthProvider(this.getOAuthProvider())
                .profileImageUrl(this.getProfileImageUrl())
                .phoneNumber(this.getPhoneNumber())
                .gender(this.getGender())
                .isDefaultImage(this.getIsDefaultImage())
                .build();
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class KakaoAccount {
        private KakaoProfile profile;
        private String email;
        private String name;
        private String gender;
        private String phone_number;
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class KakaoProfile {
        private String nickname;
        private String thumbnail_image_url;
        private String profile_image_url;
        private String is_default_image;
    }

    @Override
    public String getEmail() {
        return kakaoAccount.email;
    }

    public String getName() {
        return kakaoAccount.name;
    }

    public String getGender() {
        return kakaoAccount.gender;
    }

    public String getPhoneNumber() {
        return kakaoAccount.phone_number;
    }


    public String getNickname() {
        return kakaoAccount.profile.nickname;
    }

    public String getThumbnailImageUrl() {
        return kakaoAccount.profile.thumbnail_image_url;
    }

    public String getProfileImageUrl() {
        return kakaoAccount.profile.profile_image_url;
    }

    public String getIsDefaultImage() {
        return kakaoAccount.profile.is_default_image;
    }

    @Override
    public OAuthProvider getOAuthProvider() {
        return OAuthProvider.KAKAO;
    }


}