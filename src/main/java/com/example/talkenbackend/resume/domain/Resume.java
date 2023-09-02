package com.example.talkenbackend.resume.domain;

import com.example.talkenbackend.resume.dto.request.ResumeRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Profile profile;

    @Builder
    public Resume(final Profile profile) {
        this.profile = profile;
    }

    public void update(ResumeRequestDto resumeRequest) {
        this.profile = resumeRequest.getProfile();
    }

}
