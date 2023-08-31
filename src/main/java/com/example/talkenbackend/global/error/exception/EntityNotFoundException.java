package com.example.talkenbackend.global.error.exception;

import com.example.talkenbackend.global.error.ErrorCode;

public class EntityNotFoundException extends CustomException {

    public EntityNotFoundException(String message) {
        super(message, ErrorCode.ENTITY_NOT_FOUND);
    }
}
