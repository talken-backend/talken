package com.example.talkenbackend.oauth.service;

import com.example.talkenbackend.global.security.jwt.JwtUtil;
import com.example.talkenbackend.oauth.domain.SocialLoginUser;
import com.example.talkenbackend.oauth.dto.request.param.OAuthLoginParams;
import com.example.talkenbackend.oauth.dto.response.NaverInfoResponse;
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
public class NaverLoginServiceImpl implements OAuthLoginService {

    private final SocialLoginUserRepository socialLoginUserRepository;
    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;


    public String login(OAuthLoginParams params) {
        NaverInfoResponse oAuthInfoResponse = (NaverInfoResponse) requestOAuthInfoService.request(params);
        User user = findOrCreateMember(oAuthInfoResponse);
//        return authTokensGenerator.generate(user);
        return jwtUtil.createToken(user);

    }

    public User findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
        socialLoginUserRepository.findByEmail(oAuthInfoResponse.getEmail()).orElse(newMember(oAuthInfoResponse));
        return userRepository.findByEmail(oAuthInfoResponse.getEmail())
                .orElseGet(() -> newUser(oAuthInfoResponse));
    }


    public SocialLoginUser newMember(OAuthInfoResponse oAuthInfoResponse) {
        NaverInfoResponse naverInfoResponse = (NaverInfoResponse) oAuthInfoResponse;
        SocialLoginUser member = naverInfoResponse.toEntity();
        return socialLoginUserRepository.save(member);
    }

    public User newUser(OAuthInfoResponse oAuthInfoResponse) {
        SignupRequestDto signupRequest = SignupRequestDto.builder()
                .email(oAuthInfoResponse.getEmail())
                .username(oAuthInfoResponse.getName())
                .password("social")
                .passwordCheck("social")
                .phone(oAuthInfoResponse.getPhoneNumber()) // 카카오에서 허가가 필요해 널값으로 들어온다.
                .build();
        userRepository.findByEmail(signupRequest.getEmail()).ifPresent(user -> {
            throw new DuplicateEmailException();
        });

        UserAuthority authority = UserAuthority.USER;

        User user = signupRequest.toEntity("social", authority);
        return userRepository.save(user);
    }
}
