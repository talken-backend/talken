package com.example.talkenbackend.portfolio.dto.response;

import com.example.talkenbackend.portfolio.domain.Portfolio;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PortfolioCreateResponseDto {

    private Long portfolioId;

    @Builder
    public PortfolioCreateResponseDto(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public static PortfolioCreateResponseDto fromEntity(Portfolio portfolio) {
        return PortfolioCreateResponseDto.builder()
                .portfolioId(portfolio.getId())
                .build();
    }
}
