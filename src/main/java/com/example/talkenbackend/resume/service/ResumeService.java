package com.example.talkenbackend.resume.service;

import com.example.talkenbackend.resume.domain.Resume;
import com.example.talkenbackend.resume.domain.ResumeTag;
import com.example.talkenbackend.resume.domain.repository.ResumeRepository;
import com.example.talkenbackend.resume.domain.repository.ResumeTagRepository;
import com.example.talkenbackend.resume.dto.request.ResumeRequestDto;
import com.example.talkenbackend.resume.dto.response.ResumeCreateResponseDto;
import com.example.talkenbackend.resume.exception.NotValidKeywordException;
import com.example.talkenbackend.tag.dto.TagCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
