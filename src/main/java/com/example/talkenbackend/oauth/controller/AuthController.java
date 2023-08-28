package com.example.talkenbackend.oauth.controller;

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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final KakaoLoginServiceImpl kakaoLoginService;
    private final NaverLoginServiceImpl naverLoginService;

    @PostMapping("/kakao")
    public ResponseEntity<AuthTokens> loginKakao(@RequestBody KakaoLoginParams params) {
        return ResponseEntity.ok(kakaoLoginService.login(params));
    }

    @PostMapping("/naver")
    public ResponseEntity<AuthTokens> loginNaver(@RequestBody NaverLoginParams params) {
        return ResponseEntity.ok(naverLoginService.login(params));
    }
}