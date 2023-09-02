package com.example.talkenbackend.resume.exception;

import com.example.talkenbackend.global.exception.EntityNotFoundException;

public class ResumeNotFoundException extends EntityNotFoundException {

    public ResumeNotFoundException(Long target) {
        super(target + "을(를) 찾을 수 없습니다.");
    }
}
