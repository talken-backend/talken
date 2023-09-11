package com.example.talkenbackend.oauth.dto.response;

import com.example.talkenbackend.oauth.dto.enums.OAuthProvider;

public interface OAuthInfoResponse {
    String getEmail();
    String getName();
    OAuthProvider getOAuthProvider();

    String getNickname();

    String getThumbnailImageUrl();

    String getProfileImageUrl();

    String getPhoneNumber();

    String getGender();

    String getIsDefaultImage();
}