package com.example.talkenbackend.resume.exception;

import com.example.talkenbackend.global.error.exception.EntityNotFoundException;

public class ResumeNotFoundException extends EntityNotFoundException {

    public ResumeNotFoundException() {
        super("이력서를 찾을 수 없습니다.");
    }
}
