package com.example.talkenbackend.resume.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResumeDetailResponseDto {

    private ResumeResponseDto resumeResponse;
    //TODO: UserResponseDto 추가

    @Builder
    public ResumeDetailResponseDto(ResumeResponseDto resumeResponse) {
        this.resumeResponse = resumeResponse;
    }

    public static ResumeDetailResponseDto fromEntity(ResumeResponseDto resumeResponse) {
        return ResumeDetailResponseDto.builder()
                .resumeResponse(resumeResponse)
                .build();
    }
}
