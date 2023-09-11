package com.example.talkenbackend.resume.dto.response;

import com.example.talkenbackend.resume.domain.Resume;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResumeResponseDto {

    private String image;
    private String field;
    private String position;
    private String introduction;
    private boolean emailStatus;
    private boolean phoneStatus;

    @Builder
    public ResumeResponseDto(String image, String field, String position, String introduction,
                             boolean emailStatus, boolean phoneStatus) {
        this.image = image;
        this.field = field;
        this.position = position;
        this.introduction = introduction;
        this.emailStatus = emailStatus;
        this.phoneStatus = phoneStatus;
    }

    public static ResumeResponseDto fromEntity(Resume resume) {
        return ResumeResponseDto.builder()
                .image(resume.getProfile().getImage())
                .field(resume.getProfile().getField())
                .position(resume.getProfile().getPosition())
                .introduction(resume.getProfile().getIntroduction())
                .emailStatus(resume.getProfile().isEmailStatus())
                .phoneStatus(resume.getProfile().isPhoneStatus())
                .build();
    }
}
