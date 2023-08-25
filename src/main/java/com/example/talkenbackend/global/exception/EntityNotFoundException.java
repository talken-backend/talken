package com.example.talkenbackend.global.exception;

public class EntityNotFoundException extends CustomException {

    public EntityNotFoundException(String message) {
        super(message, ErrorCode.ENTITY_NOT_FOUND);
    }
}
