package com.example.talkenbackend.share.service;

import com.amazonaws.util.Base64;
import com.example.talkenbackend.resume.dto.response.ResumeDetailResponseDto;
import com.example.talkenbackend.resume.service.ResumeService;
import com.example.talkenbackend.share.domain.Share;
import com.example.talkenbackend.share.dto.response.ShareResponseDto;
import com.example.talkenbackend.share.repository.ShareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ShareService {
    private final ShareRepository shareRepository;
    private final ResumeService resumeService;

    public ShareResponseDto getShareLink(Long resumeId) throws Exception {

        // 중복 확인
        Optional<Share> share = shareRepository.findByResumeId(resumeId);

        // 기존 저장 url 반환
        if (share.isPresent()) {
            return ShareResponseDto.fromEntity(share.get().getShareUrl());
        }

        // 없으면 url 생성
        String url = new String(Base64.encode(UUID.randomUUID().toString().getBytes()));
        shareRepository.save(Share.builder()
                .resumeId(resumeId)
                .shareUrl(url)
                .build());
        return ShareResponseDto.fromEntity(url);
    }

    public ResumeDetailResponseDto getResumeByShareUrl(String shareUrl) {
        Share share = shareRepository.findByShareUrl(shareUrl).orElseThrow();
        return resumeService.getResume(share.getResumeId());
    }
}
