package com.example.talkenbackend.global.exception;

public class InvalidInputException extends CustomException {

    public InvalidInputException(String value) {
        super(value, ErrorCode.INVALID_INPUT);
    }

    public InvalidInputException(String value, ErrorCode code) {
        super(value, code);
    }
}
