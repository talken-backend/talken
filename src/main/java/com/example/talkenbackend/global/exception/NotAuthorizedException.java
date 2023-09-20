package com.example.talkenbackend.global.exception;

public class NotAuthorizedException extends CustomException {

    public NotAuthorizedException(ErrorCode code) {
        super(code);
    }
}
