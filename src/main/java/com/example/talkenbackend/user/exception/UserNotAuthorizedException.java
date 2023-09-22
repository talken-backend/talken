package com.example.talkenbackend.user.exception;

import com.example.talkenbackend.global.error.ErrorCode;
import com.example.talkenbackend.global.exception.NotAuthorizedException;

public class UserNotAuthorizedException extends NotAuthorizedException {
    public UserNotAuthorizedException() {
        super(ErrorCode.NOT_AUTHORIZED);
    }
}
