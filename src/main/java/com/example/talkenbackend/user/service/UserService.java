package com.example.talkenbackend.user.service;

import com.example.talkenbackend.global.security.jwt.JwtUtil;
import com.example.talkenbackend.user.domain.User;
import com.example.talkenbackend.user.domain.UserAuthority;
import com.example.talkenbackend.user.dto.request.LoginRequestDto;
import com.example.talkenbackend.user.dto.request.SignupRequestDto;
import com.example.talkenbackend.user.dto.response.UserResponseDto;
import com.example.talkenbackend.user.exception.DuplicateEmailException;
import com.example.talkenbackend.user.exception.InvalidPasswordException;
import com.example.talkenbackend.user.exception.UserNotFoundException;
import com.example.talkenbackend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignupRequestDto signupRequest) {
        userRepository.findByEmail(signupRequest.getEmail()).ifPresent( user -> {
            throw new DuplicateEmailException();
        });

        if(!signupRequest.getPassword().equals(signupRequest.getPasswordCheck())) {
            throw new InvalidPasswordException();
        }
        UserAuthority authority = UserAuthority.USER;
        String password = passwordEncoder.encode(signupRequest.getPassword());

        User user = signupRequest.toEntity(password, authority);
         userRepository.save(user);
    }

    public String login(LoginRequestDto loginRequest) {
        String password = loginRequest.getPassword();
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(
                () -> new UserNotFoundException()
        );
        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidPasswordException();
        }
        return jwtUtil.createToken(user);
    }


    public UserResponseDto getUserInfo(Long userId) throws Exception {

        User user = userRepository.findById(userId).orElseThrow(() -> new Exception());

        return UserResponseDto.fromEntity(user);
    }

    public boolean checkEmailDuplicate(String email) {
        if(userRepository.findByEmail(email).isPresent()){
            return true; // 중복
        }
        return false; // 중복X
    }
}
