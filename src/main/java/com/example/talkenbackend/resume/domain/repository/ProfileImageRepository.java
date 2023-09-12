package com.example.talkenbackend.resume.domain.repository;

import com.example.talkenbackend.resume.domain.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long> {
    List<ProfileImage> findByResumeId(Long resumeId);
}
