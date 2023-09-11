package com.example.talkenbackend.feedback.service;

import com.example.talkenbackend.feedback.domain.Feedback;
import com.example.talkenbackend.feedback.dto.request.FeedbackRequestDto;
import com.example.talkenbackend.feedback.dto.response.FeedbackResponseDto;
import com.example.talkenbackend.feedback.exception.FeedbackNotFoundException;
import com.example.talkenbackend.feedback.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.talkenbackend.feedback.dto.response.FeedbackResponseDto.fromEntity;

@RequiredArgsConstructor

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackResponseDto getFeedback(Long feedbackId) throws Exception {
        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new FeedbackNotFoundException(feedbackId));
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

    @Transactional
    public void deleteFeedback(Long feedbackId) {
        feedbackRepository.deleteById(feedbackId);
    }

    public FeedbackResponseDto createFeedback(FeedbackRequestDto dto) {
        return fromEntity(feedbackRepository.save(dto.toEntity()));
    }

    @Transactional
    public FeedbackResponseDto updateFeedback(Long feedbackId, FeedbackRequestDto dto) {
        Feedback feedback = feedbackRepository.findById(feedbackId).orElseThrow(
                () -> new FeedbackNotFoundException(feedbackId));
        feedback.update(dto);
        return fromEntity(feedback);
    }
}
