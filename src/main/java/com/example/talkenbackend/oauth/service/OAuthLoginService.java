package com.example.talkenbackend.oauth.service;

import com.example.talkenbackend.oauth.domain.SocialLoginUser;
import com.example.talkenbackend.oauth.dto.request.param.OAuthLoginParams;
import com.example.talkenbackend.oauth.dto.response.OAuthInfoResponse;
import com.example.talkenbackend.oauth.jwt.AuthTokens;
import com.example.talkenbackend.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface OAuthLoginService {
    String login(OAuthLoginParams params);
//    AuthTokens login(OAuthLoginParams params);

    User findOrCreateMember(OAuthInfoResponse oAuthInfoResponse);

    SocialLoginUser newMember(OAuthInfoResponse oAuthInfoResponse);
}