package com.example.talkenbackend.oauth.dto.response;

import com.example.talkenbackend.oauth.domain.SocialLoginUser;
import com.example.talkenbackend.oauth.dto.enums.OAuthProvider;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverInfoResponse implements OAuthInfoResponse {

    @JsonProperty("response")
    private Response response;

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
    static class Response {
        private String email;
        private String name;
        private String nickname;
    }

    @Override
    public String getEmail() {
        return response.email;
    }

    @Override
    public String getName() {
        return response.name;
    }



    @Override
    public OAuthProvider getOAuthProvider() {
        return OAuthProvider.NAVER;
    }

    @Override
    public String getNickname() {
        return response.nickname;
    }

    @Override
    public String getThumbnailImageUrl() {
        return null;
    }

    @Override
    public String getProfileImageUrl() {
        return null;
    }

    @Override
    public String getPhoneNumber() {
        return null;
    }

    @Override
    public String getGender() {
        return null;
    }

    @Override
    public String getIsDefaultImage() {
        return null;
    }
}