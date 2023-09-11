package com.example.talkenbackend.global.error.exception;

import com.example.talkenbackend.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private ErrorCode code;

    public CustomException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public CustomException(ErrorCode code) {
        this.code = code;
    }
}
