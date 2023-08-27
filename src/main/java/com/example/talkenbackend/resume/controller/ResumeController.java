package com.example.talkenbackend.resume.controller;

import com.example.talkenbackend.global.response.SuccessResponse;
import com.example.talkenbackend.resume.dto.request.ResumeRequestDto;
import com.example.talkenbackend.resume.dto.response.ResumeCreateResponseDto;
import com.example.talkenbackend.resume.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping(value = "/resumes")
    public ResponseEntity<SuccessResponse<ResumeCreateResponseDto>> createResume(@RequestBody ResumeRequestDto resumeRequest) {
        return SuccessResponse.toResponseEntity("이력서 생성 성공", resumeService.createResume(resumeRequest));
    }
}
