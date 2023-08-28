package com.example.talkenbackend.oauth.service;

import com.example.talkenbackend.oauth.domain.SocialLoginUser;
import com.example.talkenbackend.oauth.dto.request.param.OAuthLoginParams;
import com.example.talkenbackend.oauth.dto.response.KakaoInfoResponse;
import com.example.talkenbackend.oauth.dto.response.OAuthInfoResponse;
import com.example.talkenbackend.oauth.jwt.AuthTokens;
import com.example.talkenbackend.oauth.jwt.AuthTokensGenerator;
import com.example.talkenbackend.oauth.repository.SocialLoginUserRepository;
import com.example.talkenbackend.user.service.RequestOAuthInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoLoginServiceImpl implements OAuthLoginService {
    private final SocialLoginUserRepository socialLoginUserRepository;
    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;


    @Override
    public AuthTokens login(OAuthLoginParams params) {
        KakaoInfoResponse oAuthInfoResponse = (KakaoInfoResponse) requestOAuthInfoService.request(params);
        Long memberId = findOrCreateMember(oAuthInfoResponse);
        return authTokensGenerator.generate(memberId);
    }

    @Override
    public Long findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
        return socialLoginUserRepository.findByEmail(oAuthInfoResponse.getEmail())
                .map(SocialLoginUser::getId)
                .orElseGet(() -> newMember(oAuthInfoResponse));
    }

    @Override
    public Long newMember(OAuthInfoResponse oAuthInfoResponse) {
        KakaoInfoResponse kakaoInfoResponse = (KakaoInfoResponse) oAuthInfoResponse;
        SocialLoginUser member = kakaoInfoResponse.toEntity();
        return socialLoginUserRepository.save(member).getId();
    }

}
