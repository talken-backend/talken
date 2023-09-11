package com.example.talkenbackend.resume.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResumeDetailResponseDto {

    private ResumeResponseDto resumeResponse;
    //TODO: UserResponseDto 추가
    private List<ResumeTagResponseDto> resumeTagResponse;

    @Builder
    public ResumeDetailResponseDto(ResumeResponseDto resumeResponse, List<ResumeTagResponseDto> resumeTagResponse) {
        this.resumeResponse = resumeResponse;
        this.resumeTagResponse = resumeTagResponse;
    }

    public static ResumeDetailResponseDto of(ResumeResponseDto resumeResponse, List<ResumeTagResponseDto> resumeTagResponse) {
        return ResumeDetailResponseDto.builder()
                .resumeResponse(resumeResponse)
                .resumeTagResponse(resumeTagResponse)
                .build();
    }
}
