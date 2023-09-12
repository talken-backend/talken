package com.example.talkenbackend.resume.service;

import com.example.talkenbackend.global.util.AwsS3Uploader;
import com.example.talkenbackend.image.domain.Image;
import com.example.talkenbackend.image.domain.repository.ImageRepository;
import com.example.talkenbackend.resume.domain.ProfileImage;
import com.example.talkenbackend.resume.domain.Resume;
import com.example.talkenbackend.resume.domain.ResumeTag;
import com.example.talkenbackend.resume.domain.repository.ProfileImageRepository;
import com.example.talkenbackend.resume.domain.repository.ResumeRepository;
import com.example.talkenbackend.resume.domain.repository.ResumeTagRepository;
import com.example.talkenbackend.resume.dto.request.ResumeRequestDto;
import com.example.talkenbackend.resume.dto.response.*;
import com.example.talkenbackend.resume.exception.NotValidKeywordException;
import com.example.talkenbackend.resume.exception.ResumeNotFoundException;
import com.example.talkenbackend.tag.domain.Tag;
import com.example.talkenbackend.tag.domain.repository.TagRepository;
import com.example.talkenbackend.tag.dto.TagRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final ResumeTagRepository resumeTagRepository;
    private final TagRepository tagRepository;
    private final ImageRepository imageRepository;
    private final ProfileImageRepository profileImageRepository;

    private final AwsS3Uploader s3Uploader;

    private final String dirName = "/profile";

    public ResumeCreateResponseDto createResume(ResumeRequestDto resumeRequest, List<MultipartFile> files) {
        Resume resume = resumeRequest.toEntity();
        resumeRepository.save(resume);

        for(TagRequestDto tagRequest : resumeRequest.getTags()) {
            ResumeTag resumeTag = ResumeTag.builder()
                    .resume(resume)
                    .tag(tagRequest.toEntity())
                    .build();

            if(resumeRequest.getTags().size() > 5) {
                String keyword = resumeTag.getTag().getKeyword();
                throw new NotValidKeywordException(keyword);
            }

            resumeTagRepository.save(resumeTag);
        }

        List<String> imageUrlList = s3Uploader.uploadFiles(files, dirName);
        List<Image> newImageList = imageUrlList.stream()
                .map(Image::new)
                .collect(Collectors.toList());

        for(Image image : newImageList) {
            imageRepository.save(image);
            ProfileImage profileImage = ProfileImage.builder()
                    .resume(resume)
                    .image(image)
                    .build();
            profileImageRepository.save(profileImage);
        }

        return ResumeCreateResponseDto.fromEntity(resume);
    }

    @Transactional(readOnly = true)
    public ResumeDetailResponseDto getResume(Long resumeId) {
        Resume resume = checkResumeExists(resumeId);

        ResumeResponseDto resumeResponse = ResumeResponseDto.fromEntity(resume);
        //TODO: UserResponseDto 추가

        List<ResumeTag> tagList = resumeTagRepository.findByResumeId(resumeId);
        List<ResumeTagResponseDto> resumeTagResponse = tagList.stream()
                .map(ResumeTagResponseDto::fromEntity)
                .collect(Collectors.toList());

        List<ProfileImage> profileImageList = profileImageRepository.findByResumeId(resumeId);
        List<ProfileImageResponseDto> profileImageResponse = profileImageList.stream()
                .map(ProfileImageResponseDto::fromEntity)
                .collect(Collectors.toList());

        return ResumeDetailResponseDto.of(resumeResponse, resumeTagResponse, profileImageResponse);
    }

    @Transactional
    public ResumeResponseDto updateResume(Long resumeId, ResumeRequestDto resumeRequest) {
        Resume resume = checkResumeExists(resumeId);
        resume.update(resumeRequest);

        //TODO: 리팩토링할 것
        deleteTags(resumeId);

        for(TagRequestDto tagRequest : resumeRequest.getTags()) {
            ResumeTag newResumeTag = ResumeTag.builder()
                    .resume(resume)
                    .tag(tagRequest.toEntity())
                    .build();
            resumeTagRepository.save(newResumeTag);
        }

        return ResumeResponseDto.fromEntity(resume);
    }

    @Transactional
    public void deleteResume(Long resumeId) {
        Resume resume = checkResumeExists(resumeId);

        resumeRepository.delete(resume);
        deleteTags(resumeId);
    }

    private void deleteTags(Long resumeId) {
        List<ResumeTag> savedResumeTags = resumeTagRepository.findByResumeId(resumeId);
        List<Tag> savedTags = savedResumeTags.stream()
                .map(resumeTag -> resumeTag.getTag())
                .collect(Collectors.toList());

        savedResumeTags.forEach(resumeTag -> resumeTagRepository.deleteByResumeId(resumeId));
        savedTags.forEach(tag -> tagRepository.deleteById(tag.getId()));
    }

    private Resume checkResumeExists(Long resumeId) {
        return resumeRepository.findById(resumeId).orElseThrow(
                () -> new ResumeNotFoundException()
        );
    }
}
