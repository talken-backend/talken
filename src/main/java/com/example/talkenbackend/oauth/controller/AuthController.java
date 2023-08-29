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
@RequestMapping("/api/auth")
public class AuthController {
    private final KakaoLoginServiceImpl kakaoLoginService;
    private final NaverLoginServiceImpl naverLoginService;

    @PostMapping("/kakao")
    public ResponseEntity<SuccessResponse<AuthTokens>> loginKakao(@RequestBody KakaoLoginParams params) throws Exception {
        return toResponseEntity("카카오 로그인 성공", kakaoLoginService.login(params));
    }

    @PostMapping("/naver")
    public ResponseEntity<SuccessResponse<AuthTokens>> loginNaver(@RequestBody NaverLoginParams params) {
        return toResponseEntity("네이버 로그인 성공", naverLoginService.login(params));
    }
}