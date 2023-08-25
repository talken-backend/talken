package com.example.talkenbackend.feedback.repository;

import com.example.talkenbackend.feedback.domain.Feedback;
import com.example.talkenbackend.feedback.dto.FeedbackResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    Optional<List<Feedback>> findByMenteeId(Long menteeId);

    Optional<List<Feedback>> findByMentorId(Long mentorId);
}
