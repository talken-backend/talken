package com.example.talkenbackend.portfolio.service;

import com.example.talkenbackend.global.util.AwsS3Uploader;
import com.example.talkenbackend.image.domain.Image;
import com.example.talkenbackend.image.domain.repository.ImageRepository;
import com.example.talkenbackend.portfolio.domain.Portfolio;
import com.example.talkenbackend.portfolio.domain.PortfolioImage;
import com.example.talkenbackend.portfolio.domain.repository.PortfolioImageRepository;
import com.example.talkenbackend.portfolio.domain.repository.PortfolioRepository;
import com.example.talkenbackend.portfolio.dto.request.PortfolioRequestDto;
import com.example.talkenbackend.portfolio.dto.response.*;
import com.example.talkenbackend.portfolio.exeption.PortfolioNotFoundException;
import com.example.talkenbackend.resume.domain.Resume;
import com.example.talkenbackend.resume.domain.repository.ResumeRepository;
import com.example.talkenbackend.resume.exception.ResumeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final ResumeRepository resumeRepository;
    private final ImageRepository imageRepository;
    private final PortfolioImageRepository portfolioImageRepository;

    private final AwsS3Uploader s3Uploader;

    private final String dirName = "portfolio";

    public PortfolioCreateResponseDto createPortfolio(Long resumeId, PortfolioRequestDto portfolioRequest, List<MultipartFile> files) {
        Resume resume = checkResumeExists(resumeId);

        Portfolio portfolio = portfolioRequest.toEntity(resume);
        portfolioRepository.save(portfolio);

        List<String> imageUrlList = s3Uploader.uploadFiles(files, dirName);
        List<Image> newImageList = imageUrlList.stream()
                .map(Image::new)
                .collect(Collectors.toList());
        savePortfolioImages(newImageList, portfolio);

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
        PortfolioResponseDto portfolioResponse = PortfolioResponseDto.fromEntity(portfolio);

        List<PortfolioImage> portfolioImageList = portfolioImageRepository.findByPortfolioId(portfolioId);
        List<PortfolioImageResponseDto> portfolioImageResponse = portfolioImageList.stream()
                .map(PortfolioImageResponseDto::fromEntity)
                .collect(Collectors.toList());

        return PortfolioDetailResponseDto.of(portfolioResponse, portfolioImageResponse);
    }

    @Transactional
    public PortfolioResponseDto updatePortfolio(Long resumeId, Long portfolioId, PortfolioRequestDto portfolioRequest, List<MultipartFile> files) {
        checkResumeExists(resumeId);

        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow(
                () -> new PortfolioNotFoundException()
        );
        portfolio.update(portfolioRequest);

        //TODO: 리팩토링할 것
        deleteImages(portfolioId);

        List<String> imageUrlList = s3Uploader.uploadFiles(files, dirName);
        List<Image> newImageList = imageUrlList.stream()
                .map(Image::new)
                .collect(Collectors.toList());
        savePortfolioImages(newImageList, portfolio);

        return PortfolioResponseDto.fromEntity(portfolio);
    }

    @Transactional
    public void deletePortfolio(Long resumeId, Long portfolioId) {
        checkResumeExists(resumeId);

        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow(
                () -> new PortfolioNotFoundException()
        );
        portfolioRepository.delete(portfolio);
    }

    private void savePortfolioImages(List<Image> newImageList, Portfolio portfolio) {
        for(Image image : newImageList) {
            imageRepository.save(image);
            PortfolioImage portfolioImage = PortfolioImage.builder()
                    .portfolio(portfolio)
                    .image(image)
                    .build();
            portfolioImageRepository.save(portfolioImage);
        }
    }

    private void deleteImages(Long portfolioId) {
        List<PortfolioImage> savedPortfolioImages = portfolioImageRepository.findByPortfolioId(portfolioId);
        List<Image> savedImages = savedPortfolioImages.stream()
                .map(portfolioImage -> portfolioImage.getImage())
                .collect(Collectors.toList());
        savedPortfolioImages.forEach(portfolioImage -> portfolioImageRepository.deleteByPortfolioId(portfolioId));
        savedImages.forEach(image -> imageRepository.deleteById(image.getId()));
    }

    private Resume checkResumeExists(Long resumeId) {
        return resumeRepository.findById(resumeId).orElseThrow(
                () -> new ResumeNotFoundException()
        );
    }

}