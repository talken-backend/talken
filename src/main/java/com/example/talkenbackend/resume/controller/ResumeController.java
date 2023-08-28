package com.example.talkenbackend.resume.controller;

import com.example.talkenbackend.global.response.SuccessResponse;
import com.example.talkenbackend.resume.dto.request.ResumeRequestDto;
import com.example.talkenbackend.resume.dto.response.ResumeCreateResponseDto;
import com.example.talkenbackend.resume.dto.response.ResumeDetailResponseDto;
import com.example.talkenbackend.resume.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping(value = "/api/resumes")
    public ResponseEntity<SuccessResponse<ResumeCreateResponseDto>> createResume(@RequestBody ResumeRequestDto resumeRequest) {
        return SuccessResponse.toResponseEntity("이력서 생성 성공", resumeService.createResume(resumeRequest));
    }

    @GetMapping(value = "/api/resumes/{resumeId}")
    public ResponseEntity<SuccessResponse<ResumeDetailResponseDto>> getResume(@PathVariable Long resumeId) {
        return SuccessResponse.toResponseEntity(resumeService.getResume(resumeId));
    }
}
