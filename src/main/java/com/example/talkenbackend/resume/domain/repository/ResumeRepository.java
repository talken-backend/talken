package com.example.talkenbackend.resume.domain.repository;

import com.example.talkenbackend.resume.domain.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
