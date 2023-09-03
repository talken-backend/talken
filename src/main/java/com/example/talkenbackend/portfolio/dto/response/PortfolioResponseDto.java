package com.example.talkenbackend.portfolio.dto.response;

import com.example.talkenbackend.portfolio.domain.Portfolio;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PortfolioResponseDto {

    private String title;
    private Date startedAt;
    private Date finishedAt;
    private boolean isOngoing;

    @Builder
    public PortfolioResponseDto(String title, Date startedAt, Date finishedAt, boolean isOngoing) {
        this.title = title;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.isOngoing = isOngoing;
    }

    public static PortfolioResponseDto fromEntity(Portfolio portfolio) {
        return PortfolioResponseDto.builder()
                .title(portfolio.getTitle())
                .startedAt(portfolio.getStartedAt())
                .finishedAt(portfolio.getFinishedAt())
                .isOngoing(portfolio.isOngoing())
                .build();
    }
}
