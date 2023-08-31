package com.example.talkenbackend.user.exception;

import com.example.talkenbackend.global.error.exception.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(Long target) {
        super(target + "을(를) 찾을 수 없습니다.");
    }
}
