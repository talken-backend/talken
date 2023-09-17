package com.example.talkenbackend.user.service;

import com.example.talkenbackend.global.security.jwt.JwtUtil;
import com.example.talkenbackend.user.domain.User;
import com.example.talkenbackend.user.domain.UserAuthority;
import com.example.talkenbackend.user.dto.request.SignupRequestDto;
import com.example.talkenbackend.user.exception.DuplicateEmailException;
import com.example.talkenbackend.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private UserService userService;

    @Spy
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    @DisplayName("중복된 이메일을 입력할 시 예외 발생")
    void signup_duplicate_email_exception() {
        SignupRequestDto signupRequest = SignupRequestDto.builder()
                .email("talken2@gmail.com")
                .username("test")
                .password("test1234")
                .passwordCheck("test1234")
                .phone("010-1234-1234")
                .build();

        UserAuthority authority = UserAuthority.USER;
        String password = passwordEncoder.encode(signupRequest.getPassword());
        User user = signupRequest.toEntity(password, authority);

        when(userRepository.findByEmail(signupRequest.getEmail())).thenReturn(Optional.of(user));

        DuplicateEmailException exception = assertThrows(DuplicateEmailException.class, () -> {
            userService.signup(signupRequest);
        });
        assertThat(exception.getCode().getMessage()).isEqualTo("중복된 이메일이 존재합니다.");
    }

    @Test
    void login() {
    }
}