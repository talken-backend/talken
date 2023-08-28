package com.example.talkenbackend.user.controller;


import com.example.talkenbackend.user.dto.response.UserResponseDto;
import com.example.talkenbackend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public UserResponseDto getUserInfo(@PathVariable Long userId) throws Exception {
        return userService.getUserInfo(userId);
    }

    @GetMapping("/signup/{email}")
    public boolean checkEmailDuplicate(@PathVariable String email) {
        return userService.checkEmailDuplicate(email);
    }
}
