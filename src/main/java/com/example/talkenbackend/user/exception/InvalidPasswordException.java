package com.example.talkenbackend.user.exception;

import com.example.talkenbackend.global.error.ErrorCode;
import com.example.talkenbackend.global.exception.InvalidInputException;

public class InvalidPasswordException extends InvalidInputException {
    public InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}
