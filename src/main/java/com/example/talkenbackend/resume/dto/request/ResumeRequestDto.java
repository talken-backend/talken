package com.example.talkenbackend.resume.dto.request;

import com.example.talkenbackend.resume.domain.Profile;
import com.example.talkenbackend.resume.domain.Resume;
import com.example.talkenbackend.tag.dto.TagRequestDto;
import com.example.talkenbackend.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResumeRequestDto {

    private Profile profile;
    private List<TagRequestDto> tags;

    public Resume toEntity(User user) {
        return Resume.builder()
                .profile(profile)
                .user(user)
                .build();
    }
}
