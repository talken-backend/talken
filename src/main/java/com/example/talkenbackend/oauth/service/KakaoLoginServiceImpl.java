package com.example.talkenbackend.oauth.service;

import com.example.talkenbackend.global.security.jwt.JwtUtil;
import com.example.talkenbackend.oauth.domain.SocialLoginUser;
import com.example.talkenbackend.oauth.dto.request.param.OAuthLoginParams;
import com.example.talkenbackend.oauth.dto.response.KakaoInfoResponse;
import com.example.talkenbackend.oauth.dto.response.OAuthInfoResponse;
import com.example.talkenbackend.oauth.jwt.AuthTokensGenerator;
import com.example.talkenbackend.oauth.repository.SocialLoginUserRepository;
import com.example.talkenbackend.user.domain.User;
import com.example.talkenbackend.user.domain.UserAuthority;
import com.example.talkenbackend.user.dto.request.SignupRequestDto;
import com.example.talkenbackend.user.exception.DuplicateEmailException;
import com.example.talkenbackend.user.repository.UserRepository;
import com.example.talkenbackend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoLoginServiceImpl implements OAuthLoginService {
    private final SocialLoginUserRepository socialLoginUserRepository;
    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;
    private final JwtUtil jwtUtil;

    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public String login(OAuthLoginParams params) {
        KakaoInfoResponse oAuthInfoResponse = (KakaoInfoResponse) requestOAuthInfoService.request(params);
        User user = findOrCreateMember(oAuthInfoResponse);
//        return authTokensGenerator.generate(user);
        return jwtUtil.createToken(user);
    }

    @Override
    public User findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
        socialLoginUserRepository.findByEmail(oAuthInfoResponse.getEmail()).orElseGet(()->newMember(oAuthInfoResponse));
        return userRepository.findByEmail(oAuthInfoResponse.getEmail())
                .orElseGet(() -> newUser(oAuthInfoResponse));
    }

    @Override
    public SocialLoginUser newMember(OAuthInfoResponse oAuthInfoResponse) {
        KakaoInfoResponse kakaoInfoResponse = (KakaoInfoResponse) oAuthInfoResponse;
        SocialLoginUser member = kakaoInfoResponse.toEntity();
        socialLoginUserRepository.findByEmail(member.getEmail()).ifPresent( x -> {
            throw new DuplicateEmailException();
        });
        return socialLoginUserRepository.save(member);
    }
    public User newUser(OAuthInfoResponse oAuthInfoResponse) {
        SignupRequestDto signupRequest = SignupRequestDto.builder()
                .email(oAuthInfoResponse.getEmail())
                .username(oAuthInfoResponse.getNickname())
                .password("social")
                .build();
        userRepository.findByEmail(signupRequest.getEmail()).ifPresent( user -> {
            throw new DuplicateEmailException();
        });

        UserAuthority authority = UserAuthority.USER;
        User user = signupRequest.toEntity("social", authority);
        return userRepository.save(user);
    }

}
