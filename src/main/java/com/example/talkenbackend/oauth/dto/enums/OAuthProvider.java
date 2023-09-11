package com.example.talkenbackend.oauth.dto.enums;
public enum OAuthProvider {
    KAKAO("kakao"),  // enum 값에 저장될 실제 값 지정
    NAVER("naver");  // enum 값에 저장될 실제 값 지정

    private final String value;

    OAuthProvider(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
