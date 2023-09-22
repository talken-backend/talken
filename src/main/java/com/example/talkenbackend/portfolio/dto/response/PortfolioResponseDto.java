package com.example.talkenbackend.portfolio.dto.response;

import com.example.talkenbackend.portfolio.domain.Portfolio;
import com.example.talkenbackend.portfolio.domain.Retrospection;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PortfolioResponseDto {

    private String title;
    private String role;
    private int memberNumber;
    private Date startedAt;
    private Date finishedAt;
    private boolean isOngoing;
    private Retrospection retrospection;

    @Builder
    public PortfolioResponseDto(String title, String role, int memberNumber, Date startedAt, Date finishedAt,
                                boolean isOngoing, Retrospection retrospection) {
        this.title = title;
        this.role = role;
        this.memberNumber = memberNumber;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.isOngoing = isOngoing;
        this.retrospection = retrospection;
    }

    public static PortfolioResponseDto fromEntity(Portfolio portfolio) {
        return PortfolioResponseDto.builder()
                .title(portfolio.getTitle())
                .role(portfolio.getRole())
                .memberNumber(portfolio.getMemberNumber())
                .startedAt(portfolio.getStartedAt())
                .finishedAt(portfolio.getFinishedAt())
                .isOngoing(portfolio.isOngoing())
                .retrospection(portfolio.getRetrospection())
                .build();
    }
}
