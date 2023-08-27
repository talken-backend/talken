package com.example.talkenbackend.feedback.exception;

import com.example.talkenbackend.global.exception.EntityNotFoundException;

public class FeedbackNotFoundException extends EntityNotFoundException {
    public FeedbackNotFoundException(Long target) {
        super(target + "을(를) 찾을 수 없습니다.");
    }

}
