package com.example.talkenbackend.portfolio.controller;

import com.example.talkenbackend.global.response.SuccessResponse;
import com.example.talkenbackend.portfolio.dto.request.PortfolioRequestDto;
import com.example.talkenbackend.portfolio.dto.response.PortfolioCreateResponseDto;
import com.example.talkenbackend.portfolio.dto.response.PortfolioListResponseDto;
import com.example.talkenbackend.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping(value = "/api/resumes/{resumeId}/portfolios")
    public ResponseEntity<SuccessResponse<PortfolioCreateResponseDto>> createPortfolio(@PathVariable Long resumeId,
                                                                                       @RequestBody PortfolioRequestDto portfolioRequest) {
        return SuccessResponse.toResponseEntity("포트폴리오 생성 성공", portfolioService.createPortfolio(resumeId, portfolioRequest));
    }

    @GetMapping(value = "/api/resumes/{resumeId}/portfolios")
    public ResponseEntity<SuccessResponse<PortfolioListResponseDto>> getPortfolioByResumeId(@PathVariable Long resumeId) {
        return SuccessResponse.toResponseEntity(portfolioService.getPortfolioByResumeId(resumeId));
    }
}
