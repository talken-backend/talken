package com.example.talkenbackend.share.controller;


import com.example.talkenbackend.global.response.SuccessResponse;
import com.example.talkenbackend.resume.dto.response.ResumeDetailResponseDto;
import com.example.talkenbackend.share.dto.response.ShareResponseDto;
import com.example.talkenbackend.share.service.ShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/share")
@RestController
public class ShareController {
    private final ShareService shareService;

    @PostMapping("resumes/{resumeId}")
    public ResponseEntity<SuccessResponse<ShareResponseDto>>
    getShareUrl(@PathVariable Long resumeId) throws Exception {
        return SuccessResponse.toResponseEntity(shareService.getShareLink(resumeId));
    }

    @GetMapping("/{shareUrl}")
    public ResponseEntity<SuccessResponse<ResumeDetailResponseDto>>
    getResumeByShareUrl(@PathVariable String shareUrl) {
        return SuccessResponse.toResponseEntity(shareService.getResumeByShareUrl(shareUrl));
    }
}
