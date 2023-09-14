package com.example.talkenbackend.user.controller;


import com.example.talkenbackend.global.response.SuccessResponse;
import com.example.talkenbackend.global.response.TokenResponse;
import com.example.talkenbackend.user.dto.request.LoginRequestDto;
import com.example.talkenbackend.user.dto.request.SignupRequestDto;
import com.example.talkenbackend.user.dto.response.UserResponseDto;
import com.example.talkenbackend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SuccessResponse<Void>> signup(@RequestBody SignupRequestDto signupRequest) {
        userService.signup(signupRequest);
        return SuccessResponse.toResponseEntity("회원가입 성공");
    }

    @PostMapping("/login")
    public TokenResponse<Void> login(@RequestBody LoginRequestDto loginRequest) {
        return TokenResponse.response(userService.login(loginRequest), HttpStatus.OK.value());
    }

    @GetMapping("/{userId}")
    public UserResponseDto getUserInfo(@PathVariable Long userId) throws Exception {
        return userService.getUserInfo(userId);
    }

    @GetMapping("/signup/{email}")
    public boolean checkEmailDuplicate(@PathVariable String email) {
        return userService.checkEmailDuplicate(email);
    }
}
