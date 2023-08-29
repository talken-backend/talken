package com.example.talkenbackend.oauth.service;

import com.example.talkenbackend.oauth.domain.SocialLoginUser;
import com.example.talkenbackend.oauth.dto.request.param.OAuthLoginParams;
import com.example.talkenbackend.oauth.dto.response.KakaoInfoResponse;
import com.example.talkenbackend.oauth.dto.response.OAuthInfoResponse;
import com.example.talkenbackend.oauth.jwt.AuthTokens;
import com.example.talkenbackend.oauth.jwt.AuthTokensGenerator;
import com.example.talkenbackend.oauth.repository.SocialLoginUserRepository;
import com.example.talkenbackend.user.domain.User;
import com.example.talkenbackend.user.dto.response.UserSignInResponseDto;
import com.example.talkenbackend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class KakaoLoginServiceImpl implements OAuthLoginService {
    private final SocialLoginUserRepository socialLoginUserRepository;
    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;
    private final UserRepository userRepository;

    @Override
    public AuthTokens login(OAuthLoginParams params) throws Exception {
        KakaoInfoResponse oAuthInfoResponse = (KakaoInfoResponse) requestOAuthInfoService.request(params);
        Long userId = findOrCreateMember(oAuthInfoResponse);
        UserSignInResponseDto user = UserSignInResponseDto.fromEntity(userRepository.findById(userId).orElseThrow(() -> new Exception()));
        AuthTokens generate = authTokensGenerator.generate(userId);
        generate.addUser(user);
        return generate;
    }

    @Override
    public Long findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
        return socialLoginUserRepository.findByEmail(oAuthInfoResponse.getEmail())
                .map(SocialLoginUser::getId)
                .orElseGet(() -> newMember(oAuthInfoResponse));
    }

    @Transactional
    @Override
    public Long newMember(OAuthInfoResponse oAuthInfoResponse) {
        KakaoInfoResponse kakaoInfoResponse = (KakaoInfoResponse) oAuthInfoResponse;
        SocialLoginUser member = kakaoInfoResponse.toEntity();
        User user = kakaoInfoResponse.toUser();
        socialLoginUserRepository.save(member);
        return userRepository.save(user).getId();
    }

}
