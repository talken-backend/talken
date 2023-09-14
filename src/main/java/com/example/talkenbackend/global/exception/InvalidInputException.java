package com.example.talkenbackend.global.exception;

public class InvalidInputException extends CustomException {

    public InvalidInputException(ErrorCode code) {
        super(code);
    }

    public InvalidInputException(String value, ErrorCode code) {
        super(value, code);
    }
}
