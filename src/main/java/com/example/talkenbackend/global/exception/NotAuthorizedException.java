package com.example.talkenbackend.global.exception;

import com.example.talkenbackend.global.error.ErrorCode;
import com.example.talkenbackend.global.error.exception.CustomException;

public class NotAuthorizedException extends CustomException {

    public NotAuthorizedException(ErrorCode code) {
        super(code);
    }
}
