package com.example.talkenbackend.resume.exception;

import com.example.talkenbackend.global.exception.ErrorCode;
import com.example.talkenbackend.global.exception.InvalidInputException;

public class InvalidKeywordException extends InvalidInputException {
    public InvalidKeywordException(final String keyword) {
        super(keyword, ErrorCode.INVALID_KEYWORD);
    }
}
