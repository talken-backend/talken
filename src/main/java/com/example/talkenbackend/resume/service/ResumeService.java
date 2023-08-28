package com.example.talkenbackend.resume.service;

import com.example.talkenbackend.resume.domain.Resume;
import com.example.talkenbackend.resume.domain.ResumeTag;
import com.example.talkenbackend.resume.domain.repository.ResumeRepository;
import com.example.talkenbackend.resume.domain.repository.ResumeTagRepository;
import com.example.talkenbackend.resume.dto.request.ResumeRequestDto;
import com.example.talkenbackend.resume.dto.response.ResumeCreateResponseDto;
import com.example.talkenbackend.resume.dto.response.ResumeDetailResponseDto;
import com.example.talkenbackend.resume.dto.response.ResumeResponseDto;
import com.example.talkenbackend.resume.dto.response.ResumeTagResponseDto;
import com.example.talkenbackend.resume.exception.NotValidKeywordException;
import com.example.talkenbackend.resume.exception.ResumeNotFoundException;
import com.example.talkenbackend.tag.dto.TagCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final ResumeTagRepository resumeTagRepository;

    @Transactional
    public ResumeCreateResponseDto createResume(ResumeRequestDto resumeRequest) {
        Resume resume = resumeRequest.toEntity();
        resumeRepository.save(resume);

        for(TagCreateRequestDto tagRequest : resumeRequest.getTags()) {
            ResumeTag resumeTag = ResumeTag.builder()
                    .resume(resume)
                    .tag(tagRequest.toEntity())
                    .build();

            if(resumeRequest.getTags().size() > 5) {
                String keyword = resumeTag.getTag().getKeyword();
                throw new NotValidKeywordException(keyword);
            }

            resumeTagRepository.save(resumeTag);
        }
        return ResumeCreateResponseDto.fromEntity(resume);
    }

    @Transactional(readOnly = true)
    public ResumeDetailResponseDto getResume(Long resumeId) {
        Resume resume = resumeRepository.findById(resumeId).orElseThrow(
                () -> new ResumeNotFoundException(resumeId)
        );

        ResumeResponseDto resumeResponse = ResumeResponseDto.fromEntity(resume);
        //TODO: UserResponseDto 추가

        List<ResumeTag> tagList = resumeTagRepository.findByResumeId(resumeId);
        List<ResumeTagResponseDto> resumeTagResponse = tagList.stream()
                .map(ResumeTagResponseDto::fromEntity)
                .collect(Collectors.toList());

        return ResumeDetailResponseDto.fromEntity(resumeResponse, resumeTagResponse);
    }
}
