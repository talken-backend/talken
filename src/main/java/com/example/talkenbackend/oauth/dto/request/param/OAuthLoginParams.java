package com.example.talkenbackend.oauth.dto.request.param;

import com.example.talkenbackend.oauth.dto.enums.OAuthProvider;
import org.springframework.util.MultiValueMap;

public interface OAuthLoginParams {
    OAuthProvider oAuthProvider();
    MultiValueMap<String, String> makeBody();
}