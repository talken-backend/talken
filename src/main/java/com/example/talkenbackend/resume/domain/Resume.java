package com.example.talkenbackend.resume.domain;

import com.example.talkenbackend.resume.dto.request.ResumeRequestDto;
import com.example.talkenbackend.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Resume(final Profile profile, User user) {
        this.profile = profile;
        this.user = user;
    }

    public void update(ResumeRequestDto resumeRequest) {
        this.profile = resumeRequest.getProfile();
    }

}
