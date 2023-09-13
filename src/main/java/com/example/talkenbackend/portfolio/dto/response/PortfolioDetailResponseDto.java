package com.example.talkenbackend.portfolio.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PortfolioDetailResponseDto {

    private PortfolioResponseDto portfolioResponse;
    private List<PortfolioImageResponseDto> portfolioImageResponse;

    @Builder
    public PortfolioDetailResponseDto(PortfolioResponseDto portfolioResponse,
                                      List<PortfolioImageResponseDto> portfolioImageResponse) {
        this.portfolioResponse = portfolioResponse;
        this.portfolioImageResponse = portfolioImageResponse;
    }

    public static PortfolioDetailResponseDto of(PortfolioResponseDto portfolioResponse,
                                                List<PortfolioImageResponseDto> portfolioImageResponse) {
        return PortfolioDetailResponseDto.builder()
                .portfolioResponse(portfolioResponse)
                .portfolioImageResponse(portfolioImageResponse)
                .build();
    }
}
