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
    private String role;
    private int memberNumber;
    private String startedAt;
    private String finishedAt;
    private boolean isOngoing;

    private String background;
    private String objective;
    private String detailRole;
    private String performance;
    private String improvement;

    @Builder
    public PortfolioResponseDto(String title, String role, int memberNumber, String startedAt, String finishedAt,
                                boolean isOngoing, String background, String objective, String detailRole,
                                String performance, String improvement) {
        this.title = title;
        this.role = role;
        this.memberNumber = memberNumber;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.isOngoing = isOngoing;
        this.background = background;
        this.objective = objective;
        this.detailRole = detailRole;
        this.performance = performance;
        this.improvement = improvement;
    }

    public static PortfolioResponseDto fromEntity(Portfolio portfolio) {
        return PortfolioResponseDto.builder()
                .title(portfolio.getTitle())
                .role(portfolio.getRole())
                .memberNumber(portfolio.getMemberNumber())
                .startedAt(portfolio.getStartedAt())
                .finishedAt(portfolio.getFinishedAt())
                .isOngoing(portfolio.isOngoing())
                .background(portfolio.getRetrospection().getBackground())
                .objective(portfolio.getRetrospection().getObjective())
                .detailRole(portfolio.getRetrospection().getDetailRole())
                .performance(portfolio.getRetrospection().getPerformance())
                .improvement(portfolio.getRetrospection().getImprovement())
                .build();
    }
}
