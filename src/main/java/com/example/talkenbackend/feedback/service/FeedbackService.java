package com.example.talkenbackend.feedback.service;

import com.example.talkenbackend.feedback.domain.Feedback;
import com.example.talkenbackend.feedback.dto.FeedbackResponseDto;
import com.example.talkenbackend.feedback.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.talkenbackend.feedback.dto.FeedbackResponseDto.fromEntity;

@RequiredArgsConstructor

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackResponseDto getFeedback(Long feedbackId) throws Exception {
        Feedback feedback = feedbackRepository.findById(feedbackId).orElseThrow(() -> new Exception());
        return fromEntity(feedback);
    }

    public List<FeedbackResponseDto> getFeedbackByMenteeId(Long menteeId) throws Exception {
        return feedbackRepository.findByMenteeId(menteeId).orElseThrow(() -> new Exception())
                .stream().map(x -> fromEntity(x)).collect(Collectors.toList());

    }

    public List<FeedbackResponseDto> getFeedbackByMentorId(Long mentorId) throws Exception {
        return feedbackRepository.findByMentorId(mentorId).orElseThrow(() -> new Exception())
                .stream().map(x -> fromEntity(x)).collect(Collectors.toList());

    }
}