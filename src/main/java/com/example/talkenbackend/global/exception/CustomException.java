package com.example.talkenbackend.global.exception;

import lombok.AllArgsConstructor;
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
