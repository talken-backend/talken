package com.example.talkenbackend.global.error.exception;

import com.example.talkenbackend.global.error.ErrorCode;

public class InvalidInputException extends CustomException {

//    public InvalidInputException(String value) {
//        super(value, ErrorCode.INVALID_INPUT);
//    }

    public InvalidInputException(String value, ErrorCode code) {
        super(value, code);
    }
}
