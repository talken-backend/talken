package com.example.talkenbackend.resume.dto.response;

import com.example.talkenbackend.resume.domain.Resume;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResumeUpdateResponseDto {

    private String image;
    private String field;
    private String position;
    private String introduction;

    @Builder
    public ResumeUpdateResponseDto(String image, String field, String position, String introduction) {
        this.image = image;
        this.field = field;
        this.position = position;
        this.introduction = introduction;
    }

    public static ResumeUpdateResponseDto fromEntity(Resume resume) {
        return ResumeUpdateResponseDto.builder()
                .image(resume.getProfile().getImage())
                .field(resume.getProfile().getField())
                .position(resume.getProfile().getPosition())
                .introduction(resume.getProfile().getIntroduction())
                .build();
    }
}
