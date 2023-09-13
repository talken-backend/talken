package com.example.talkenbackend.portfolio.domain.repository;

import com.example.talkenbackend.portfolio.domain.PortfolioImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioImageRepository extends JpaRepository<PortfolioImage, Long> {
    List<PortfolioImage> findByPortfolioId(Long portfolioId);
    void deleteByPortfolioId(Long PortfolioId);
}
