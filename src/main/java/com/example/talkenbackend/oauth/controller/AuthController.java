package com.example.talkenbackend.oauth.controller;

import com.example.talkenbackend.global.response.TokenResponse;
import com.example.talkenbackend.oauth.dto.request.param.KakaoLoginParams;
import com.example.talkenbackend.oauth.dto.request.param.NaverLoginParams;
import com.example.talkenbackend.oauth.service.KakaoLoginServiceImpl;
import com.example.talkenbackend.oauth.service.NaverLoginServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final KakaoLoginServiceImpl kakaoLoginService;
    private final NaverLoginServiceImpl naverLoginService;

    @PostMapping("/oauth/kakaoCallback")
    public TokenResponse<Void> loginKakao(@RequestBody KakaoLoginParams params) {
        return TokenResponse.response(kakaoLoginService.login(params), HttpStatus.OK.value());
    }

    @PostMapping("/oauth/naverCallback")
    public TokenResponse<Void> loginNaver(@RequestBody NaverLoginParams params) {
        return TokenResponse.response(naverLoginService.login(params), HttpStatus.OK.value());
    }
}