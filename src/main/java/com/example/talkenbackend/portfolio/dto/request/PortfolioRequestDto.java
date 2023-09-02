package com.example.talkenbackend.portfolio.dto.request;

import com.example.talkenbackend.portfolio.domain.Portfolio;
import com.example.talkenbackend.portfolio.domain.Retrospection;
import com.example.talkenbackend.resume.domain.Resume;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PortfolioRequestDto {

    private String title;
    private String role;
    private int memberNumber;
    private String startedAt;
    private String finishedAt;
    private boolean isOngoing;

    private Retrospection retrospection;

    public Portfolio toEntity(Resume resume) {
        return Portfolio.builder()
                .title(title)
                .role(role)
                .memberNumber(memberNumber)
                .startedAt(startedAt)
                .finishedAt(finishedAt)
                .isOngoing(isOngoing)
                .retrospection(retrospection)
                .resume(resume)
                .build();
    }
}
