package com.example.talkenbackend.portfolio.dto.response;

import com.example.talkenbackend.portfolio.domain.PortfolioImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PortfolioImageResponseDto {

    private String imageUrl;

    @Builder
    public PortfolioImageResponseDto(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static PortfolioImageResponseDto fromEntity(PortfolioImage portfolioImage) {
        return PortfolioImageResponseDto.builder()
                .imageUrl(portfolioImage.getImage().getImageUrl())
                .build();
    }
}
