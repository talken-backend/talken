package com.example.talkenbackend.global.exception;

import com.example.talkenbackend.global.error.ErrorCode;
import com.example.talkenbackend.global.error.exception.CustomException;

public class InvalidInputException extends CustomException {

    public InvalidInputException(ErrorCode code) {
        super(code);
    }

    public InvalidInputException(String value, ErrorCode code) {
        super(value, code);
    }
}
