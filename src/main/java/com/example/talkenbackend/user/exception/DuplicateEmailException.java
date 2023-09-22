package com.example.talkenbackend.user.exception;

import com.example.talkenbackend.global.error.ErrorCode;
import com.example.talkenbackend.global.exception.InvalidInputException;

public class DuplicateEmailException extends InvalidInputException {
    public DuplicateEmailException() {
        super(ErrorCode.DUPLICATE_EMAIL);
    }
}
