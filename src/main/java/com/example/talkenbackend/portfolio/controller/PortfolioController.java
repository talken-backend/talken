package com.example.talkenbackend.portfolio.controller;

import com.example.talkenbackend.global.response.SuccessResponse;
import com.example.talkenbackend.portfolio.dto.request.PortfolioRequestDto;
import com.example.talkenbackend.portfolio.dto.response.PortfolioResponseDto;
import com.example.talkenbackend.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping(value = "/api/resumes/{resumeId}/portfolios")
    public ResponseEntity<SuccessResponse<PortfolioResponseDto>> createPortfolio(@PathVariable Long resumeId,
                                                                                 @RequestBody PortfolioRequestDto portfolioRequest) {
        return SuccessResponse.toResponseEntity("포트폴리오 생성 성공", portfolioService.createPortfolio(resumeId, portfolioRequest));
    }
}
