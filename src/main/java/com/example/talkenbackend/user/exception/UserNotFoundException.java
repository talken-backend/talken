package com.example.talkenbackend.user.exception;

import com.example.talkenbackend.global.exception.EntityNotFoundException;
import com.example.talkenbackend.global.exception.ErrorCode;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException() {
        super("사용자를 찾을 수 없습니다.");
    }
}
