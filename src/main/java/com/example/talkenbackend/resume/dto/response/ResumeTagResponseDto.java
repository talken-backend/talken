package com.example.talkenbackend.resume.dto.response;

import com.example.talkenbackend.resume.domain.ResumeTag;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResumeTagResponseDto {

    private String keyword;

    @Builder
    public ResumeTagResponseDto(ResumeTag resumeTag) {
        this.keyword = resumeTag.getTag().getKeyword();
    }

    public static ResumeTagResponseDto fromEntity(ResumeTag resumeTag) {
        return ResumeTagResponseDto.builder()
                .resumeTag(resumeTag)
                .build();
    }
}
