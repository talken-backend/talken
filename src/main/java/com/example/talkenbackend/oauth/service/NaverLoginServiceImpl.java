package com.example.talkenbackend.oauth.service;

import com.example.talkenbackend.oauth.domain.SocialLoginUser;
import com.example.talkenbackend.oauth.dto.request.param.OAuthLoginParams;
import com.example.talkenbackend.oauth.dto.response.NaverInfoResponse;
import com.example.talkenbackend.oauth.dto.response.OAuthInfoResponse;
import com.example.talkenbackend.oauth.jwt.AuthTokens;
import com.example.talkenbackend.oauth.jwt.AuthTokensGenerator;
import com.example.talkenbackend.oauth.repository.SocialLoginUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverLoginServiceImpl implements OAuthLoginService {

    private final SocialLoginUserRepository socialLoginUserRepository;
    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;

    public AuthTokens login(OAuthLoginParams params) {
        NaverInfoResponse oAuthInfoResponse = (NaverInfoResponse) requestOAuthInfoService.request(params);
        Long memberId = findOrCreateMember(oAuthInfoResponse);
        return authTokensGenerator.generate(memberId);
    }

    public Long findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
        return socialLoginUserRepository.findByEmail(oAuthInfoResponse.getEmail())
                .map(SocialLoginUser::getId)
                .orElseGet(() -> newMember(oAuthInfoResponse));
    }


    public Long newMember(OAuthInfoResponse oAuthInfoResponse) {
        SocialLoginUser member = SocialLoginUser.builder()
                .email(oAuthInfoResponse.getEmail())
                .name(oAuthInfoResponse.getName())
                .name(oAuthInfoResponse.getName())
                .oAuthProvider(oAuthInfoResponse.getOAuthProvider())
                .build();

        return socialLoginUserRepository.save(member).getId();
    }
}
