package com.example.talkenbackend.portfolio.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PortfolioListResponseDto {

    private List<PortfolioResponseDto> portfolioResponseList = new ArrayList<>();

    @Builder
    public PortfolioListResponseDto(List<PortfolioResponseDto> portfolioResponseList) {
        this.portfolioResponseList = portfolioResponseList;
    }

    public static PortfolioListResponseDto of(List<PortfolioResponseDto> portfolioResponseList) {
        return PortfolioListResponseDto.builder()
                .portfolioResponseList(portfolioResponseList)
                .build();
    }
}
