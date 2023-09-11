package com.example.talkenbackend.portfolio.service;

import com.example.talkenbackend.portfolio.domain.Portfolio;
import com.example.talkenbackend.portfolio.domain.repository.PortfolioRepository;
import com.example.talkenbackend.portfolio.dto.request.PortfolioRequestDto;
import com.example.talkenbackend.portfolio.dto.response.PortfolioCreateResponseDto;
import com.example.talkenbackend.portfolio.dto.response.PortfolioDetailResponseDto;
import com.example.talkenbackend.portfolio.dto.response.PortfolioListResponseDto;
import com.example.talkenbackend.portfolio.dto.response.PortfolioResponseDto;
import com.example.talkenbackend.portfolio.exeption.PortfolioNotFoundException;
import com.example.talkenbackend.resume.domain.Resume;
import com.example.talkenbackend.resume.domain.repository.ResumeRepository;
import com.example.talkenbackend.resume.exception.ResumeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final ResumeRepository resumeRepository;

    public PortfolioCreateResponseDto createPortfolio(Long resumeId, PortfolioRequestDto portfolioRequest) {
        Resume resume = checkResumeExists(resumeId);

        Portfolio portfolio = portfolioRequest.toEntity(resume);
        portfolioRepository.save(portfolio);

        return PortfolioCreateResponseDto.fromEntity(portfolio);
    }

    @Transactional(readOnly = true)
    public PortfolioListResponseDto getPortfolioByResumeId(Long resumeId) {
        List<Portfolio> portfolio = portfolioRepository.findByResumeId(resumeId);
        List<PortfolioResponseDto> portfolioResponseList = portfolio.stream()
                .map(PortfolioResponseDto::fromEntity)
                .collect(Collectors.toList());

        return PortfolioListResponseDto.of(portfolioResponseList);
    }

    @Transactional(readOnly = true)
    public PortfolioDetailResponseDto getPortfolio(Long resumeId, Long portfolioId) {
        checkResumeExists(resumeId);

        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow(
                () -> new PortfolioNotFoundException()
        );

        return PortfolioDetailResponseDto.fromEntity(portfolio);
    }

    @Transactional
    public PortfolioDetailResponseDto updatePortfolio(Long resumeId, Long portfolioId, PortfolioRequestDto portfolioRequest) {
        checkResumeExists(resumeId);

        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow(
                () -> new PortfolioNotFoundException()
        );
        portfolio.update(portfolioRequest);

        return PortfolioDetailResponseDto.fromEntity(portfolio);
    }

    @Transactional
    public void deletePortfolio(Long resumeId, Long portfolioId) {
        checkResumeExists(resumeId);

        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow(
                () -> new PortfolioNotFoundException()
        );
        portfolioRepository.delete(portfolio);
    }

    private Resume checkResumeExists(Long resumeId) {
        return resumeRepository.findById(resumeId).orElseThrow(
                () -> new ResumeNotFoundException()
        );
    }

}