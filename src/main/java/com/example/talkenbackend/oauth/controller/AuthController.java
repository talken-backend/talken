package com.example.talkenbackend.oauth.controller;

import com.example.talkenbackend.global.response.SuccessResponse;
import com.example.talkenbackend.oauth.dto.request.param.KakaoLoginParams;
import com.example.talkenbackend.oauth.dto.request.param.NaverLoginParams;
import com.example.talkenbackend.oauth.jwt.AuthTokens;
import com.example.talkenbackend.oauth.service.KakaoLoginServiceImpl;
import com.example.talkenbackend.oauth.service.NaverLoginServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.talkenbackend.global.response.SuccessResponse.toResponseEntity;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final KakaoLoginServiceImpl kakaoLoginService;
    private final NaverLoginServiceImpl naverLoginService;

    @PostMapping("/oauth/kakaoCallback")
    public ResponseEntity<SuccessResponse<ResponseEntity<AuthTokens>>> loginKakao(@RequestBody KakaoLoginParams params) {
        return toResponseEntity("카카오 로그인 성공", ResponseEntity.ok(kakaoLoginService.login(params)));
    }

    @PostMapping("/oauth/naverCallback")
    public ResponseEntity<SuccessResponse<ResponseEntity<AuthTokens>>> loginNaver(@RequestBody NaverLoginParams params) {
        return toResponseEntity("네이버 로그인 성공", ResponseEntity.ok(naverLoginService.login(params)));
    }
}