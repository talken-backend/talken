package com.example.talkenbackend.resume.domain.repository;

import com.example.talkenbackend.resume.domain.ResumeTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeTagRepository extends JpaRepository<ResumeTag, Long> {
    List<ResumeTag> findByResumeId(Long resumeId);
    void deleteByResumeId(Long resumeId);
}
