package com.example.talkenbackend.user.exception;

import com.example.talkenbackend.global.error.ErrorCode;
import com.example.talkenbackend.global.error.exception.InvalidInputException;

public class DuplicateEmailException extends InvalidInputException {

    public DuplicateEmailException(final String email) {
        super(email, ErrorCode.DUPLICATE_EMAIL);
    }
}