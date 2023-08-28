package com.example.talkenbackend.user.service;

import com.example.talkenbackend.user.domain.User;
import com.example.talkenbackend.user.dto.response.UserResponseDto;
import com.example.talkenbackend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
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
