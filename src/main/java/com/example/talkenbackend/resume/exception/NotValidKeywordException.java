package com.example.talkenbackend.resume.exception;

import com.example.talkenbackend.global.exception.ErrorCode;
import com.example.talkenbackend.global.exception.InvalidInputException;

public class NotValidKeywordException extends InvalidInputException {
    public NotValidKeywordException(final String keyword) {
        super(keyword, ErrorCode.NOT_INVALID_KEYWORD);
    }
}
