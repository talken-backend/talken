package com.example.talkenbackend.portfolio.domain.repository;

import com.example.talkenbackend.portfolio.domain.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findByResumeId(Long resumeId);
}
