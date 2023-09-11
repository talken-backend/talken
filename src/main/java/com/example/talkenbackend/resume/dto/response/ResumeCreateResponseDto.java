package com.example.talkenbackend.resume.dto.response;

import com.example.talkenbackend.resume.domain.Resume;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResumeCreateResponseDto {

    private Long resumeId;

    @Builder
    public ResumeCreateResponseDto(Long resumeId) {
        this.resumeId = resumeId;
    }

    public static ResumeCreateResponseDto fromEntity(Resume resume) {
        return ResumeCreateResponseDto.builder()
                .resumeId(resume.getId())
                .build();
    }
}
