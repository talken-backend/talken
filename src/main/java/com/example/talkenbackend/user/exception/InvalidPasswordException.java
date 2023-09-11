package com.example.talkenbackend.user.exception;

import com.example.talkenbackend.global.error.ErrorCode;
import com.example.talkenbackend.global.error.exception.InvalidInputException;

public class InvalidPasswordException extends InvalidInputException {
    //TODO: 리팩토링할 것
    public InvalidPasswordException(final String password) {
        super(password, ErrorCode.INVALID_PASSWORD);
    }
}
