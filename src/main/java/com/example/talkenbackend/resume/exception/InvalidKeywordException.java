package com.example.talkenbackend.resume.exception;

import com.example.talkenbackend.global.exception.InvalidInputException;
import com.example.talkenbackend.global.error.ErrorCode;

public class InvalidKeywordException extends InvalidInputException {
    public InvalidKeywordException(final String keyword) {
        super(keyword, ErrorCode.INVALID_KEYWORD);
    }
}
