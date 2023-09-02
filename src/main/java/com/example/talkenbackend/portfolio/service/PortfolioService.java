package com.example.talkenbackend.portfolio.service;

import com.example.talkenbackend.portfolio.domain.Portfolio;
import com.example.talkenbackend.portfolio.domain.repository.PortfolioRepository;
import com.example.talkenbackend.portfolio.dto.request.PortfolioRequestDto;
import com.example.talkenbackend.portfolio.dto.response.PortfolioResponseDto;
import com.example.talkenbackend.resume.domain.Resume;
import com.example.talkenbackend.resume.domain.repository.ResumeRepository;
import com.example.talkenbackend.resume.exception.ResumeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final ResumeRepository resumeRepository;

    public PortfolioResponseDto createPortfolio(Long resumeId, PortfolioRequestDto portfolioRequest) {
        Resume resume = resumeRepository.findById(resumeId).orElseThrow(
                () -> new ResumeNotFoundException(resumeId)
        );
        Portfolio portfolio = portfolioRequest.toEntity(resume);
        portfolioRepository.save(portfolio);

        return PortfolioResponseDto.fromEntity(portfolio);
    }
}
