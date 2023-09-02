package com.example.talkenbackend.portfolio.domain;

import com.example.talkenbackend.resume.domain.Resume;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO: 커버 이미지, 파일 첨부 추가

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String role;    // 담당 역할

    @Column(nullable = false)
    private int memberNumber;   // 팀원 수

    @Column(nullable = false)
    private String startedAt;

    private String finishedAt;

    private boolean isOngoing;  // 진행중

    @Embedded
    private Retrospection retrospection;    // 회고록

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @Builder
    public Portfolio(String title, String role, int memberNumber, String startedAt, String finishedAt, boolean isOngoing,
                     final Retrospection retrospection, Resume resume) {
        this.title = title;
        this.role = role;
        this.memberNumber = memberNumber;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.isOngoing = isOngoing;
        this.retrospection = retrospection;
        this.resume = resume;
    }
}
