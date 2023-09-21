package com.example.talkenbackend.resume.exception;

<<<<<<< HEAD
import com.example.talkenbackend.global.exception.ErrorCode;
import com.example.talkenbackend.global.exception.InvalidInputException;
=======
import com.example.talkenbackend.global.error.ErrorCode;
import com.example.talkenbackend.global.error.exception.InvalidInputException;
>>>>>>> prod

public class InvalidKeywordException extends InvalidInputException {
    public InvalidKeywordException(final String keyword) {
        super(keyword, ErrorCode.INVALID_KEYWORD);
    }
}
