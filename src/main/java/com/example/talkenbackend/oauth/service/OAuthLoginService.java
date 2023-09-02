package com.example.talkenbackend.oauth.service;

import com.example.talkenbackend.oauth.dto.request.param.OAuthLoginParams;
import com.example.talkenbackend.oauth.dto.response.OAuthInfoResponse;
import com.example.talkenbackend.oauth.jwt.AuthTokens;
import org.springframework.stereotype.Service;

@Service
public interface OAuthLoginService {
    AuthTokens login(OAuthLoginParams params);

    Long findOrCreateMember(OAuthInfoResponse oAuthInfoResponse);

    Long newMember(OAuthInfoResponse oAuthInfoResponse);
}