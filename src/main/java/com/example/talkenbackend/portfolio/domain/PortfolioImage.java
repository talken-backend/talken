package com.example.talkenbackend.portfolio.domain;

import com.example.talkenbackend.image.domain.Image;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PortfolioImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @Builder
    public PortfolioImage(Portfolio portfolio, Image image) {
        this.portfolio = portfolio;
        this.image = image;
    }
}
