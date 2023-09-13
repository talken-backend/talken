package com.example.talkenbackend.portfolio.controller;

import com.example.talkenbackend.global.response.SuccessResponse;
import com.example.talkenbackend.portfolio.dto.request.PortfolioRequestDto;
import com.example.talkenbackend.portfolio.dto.response.PortfolioCreateResponseDto;
import com.example.talkenbackend.portfolio.dto.response.PortfolioDetailResponseDto;
import com.example.talkenbackend.portfolio.dto.response.PortfolioListResponseDto;
import com.example.talkenbackend.portfolio.dto.response.PortfolioResponseDto;
import com.example.talkenbackend.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping(value = "/api/resumes/{resumeId}/portfolios", consumes = {"multipart/form-data"})
    public ResponseEntity<SuccessResponse<PortfolioCreateResponseDto>> createPortfolio(@PathVariable Long resumeId,
                                                                                       @RequestPart(name = "data") PortfolioRequestDto portfolioRequest,
                                                                                       @RequestPart(name = "file", required = false) List<MultipartFile> files) {
        return SuccessResponse.toResponseEntity("포트폴리오 생성 성공", portfolioService.createPortfolio(resumeId, portfolioRequest, files));
    }

    @GetMapping(value = "/api/resumes/{resumeId}/portfolios")
    public ResponseEntity<SuccessResponse<PortfolioListResponseDto>> getPortfolioByResumeId(@PathVariable Long resumeId) {
        return SuccessResponse.toResponseEntity(portfolioService.getPortfolioByResumeId(resumeId));
    }

    @GetMapping(value = "/api/resumes/{resumeId}/portfolios/{portfolioId}")
    public ResponseEntity<SuccessResponse<PortfolioDetailResponseDto>> getPortfolio(@PathVariable Long resumeId,
                                                                                    @PathVariable Long portfolioId) {
        return SuccessResponse.toResponseEntity(portfolioService.getPortfolio(resumeId, portfolioId));
    }

    @PutMapping(value = "/api/resumes/{resumeId}/portfolios/{portfolioId}")
    public ResponseEntity<SuccessResponse<PortfolioResponseDto>> updatePortfolio(@PathVariable Long resumeId,
                                                                                 @PathVariable Long portfolioId,
                                                                                 @RequestPart(name = "data") PortfolioRequestDto portfolioRequest,
                                                                                 @RequestPart(name = "file", required = false) List<MultipartFile> files) {
        return SuccessResponse.toResponseEntity("포트폴리오 업데이트 성공", portfolioService.updatePortfolio(resumeId, portfolioId, portfolioRequest, files));
    }

    @DeleteMapping(value = "/api/resumes/{resumeId}/portfolios/{portfolioId}")
    public ResponseEntity<SuccessResponse<Void>> deletePortfolio(@PathVariable Long resumeId,
                                                                 @PathVariable Long portfolioId) {
        portfolioService.deletePortfolio(resumeId, portfolioId);
        return SuccessResponse.toResponseEntity("포트폴리오 삭제 성공");
    }
}
