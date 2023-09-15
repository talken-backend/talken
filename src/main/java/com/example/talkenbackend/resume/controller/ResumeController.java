package com.example.talkenbackend.resume.controller;

import com.example.talkenbackend.global.response.SuccessResponse;
import com.example.talkenbackend.global.security.UserDetailsImpl;
import com.example.talkenbackend.resume.dto.request.ResumeRequestDto;
import com.example.talkenbackend.resume.dto.response.ResumeCreateResponseDto;
import com.example.talkenbackend.resume.dto.response.ResumeDetailResponseDto;
import com.example.talkenbackend.resume.dto.response.ResumeResponseDto;
import com.example.talkenbackend.resume.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping(value = "/api/resumes", consumes = {"multipart/form-data"})
    public ResponseEntity<SuccessResponse<ResumeCreateResponseDto>> createResume(@RequestPart(name = "data") ResumeRequestDto resumeRequest,
                                                                                 @RequestPart(name = "file", required = false) List<MultipartFile> files,
                                                                                 @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return SuccessResponse.toResponseEntity("이력서 생성 성공", resumeService.createResume(resumeRequest, files, userDetails));
    }

    @GetMapping(value = "/api/resumes/{resumeId}")
    public ResponseEntity<SuccessResponse<ResumeDetailResponseDto>> getResume(@PathVariable Long resumeId) {
        return SuccessResponse.toResponseEntity(resumeService.getResume(resumeId));
    }

    @PutMapping(value = "/api/resumes/{resumeId}")
    public ResponseEntity<SuccessResponse<ResumeResponseDto>> updateResume(@PathVariable Long resumeId,
                                                                           @RequestBody ResumeRequestDto resumeRequest,
                                                                           @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return SuccessResponse.toResponseEntity("이력서 수정 성공", resumeService.updateResume(resumeId, resumeRequest, userDetails));
    }

    @DeleteMapping(value = "/api/resumes/{resumeId}")
    public ResponseEntity<SuccessResponse<Void>> deleteResume(@PathVariable Long resumeId,
                                                              @AuthenticationPrincipal UserDetailsImpl userDetails) {
        resumeService.deleteResume(resumeId, userDetails);
        return SuccessResponse.toResponseEntity("이력서 삭제 성공");
    }
}
