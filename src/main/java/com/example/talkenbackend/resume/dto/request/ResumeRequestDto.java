package com.example.talkenbackend.resume.dto.request;

import com.example.talkenbackend.resume.domain.Profile;
import com.example.talkenbackend.resume.domain.Resume;
import com.example.talkenbackend.tag.dto.TagCreateRequestDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResumeRequestDto {

    private Profile profile;
    private List<TagCreateRequestDto> tags;

    public Resume toEntity() {
        return Resume.builder()
                .profile(profile)
                .build();
    }
}
