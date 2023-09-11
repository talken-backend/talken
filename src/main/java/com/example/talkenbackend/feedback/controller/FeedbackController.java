package com.example.talkenbackend.feedback.controller;

import com.example.talkenbackend.feedback.dto.FeedbackResponseDto;
import com.example.talkenbackend.feedback.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/feedbacks")
@RequiredArgsConstructor
@RestController
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping("/{feedbackId}")
    public FeedbackResponseDto getFeedback(@PathVariable Long feedbackId) throws Exception {
        return feedbackService.getFeedback(feedbackId);
    }
    @GetMapping("mentee/{menteeId}") // menteeId는 User 테이블의 userId
    public List<FeedbackResponseDto> getFeedbackByMenteeId(@PathVariable Long menteeId) throws Exception {
        return feedbackService.getFeedbackByMenteeId(menteeId);
    }
    @GetMapping("mentor/{mentorId}")
    public List<FeedbackResponseDto> getFeedbackByMentorId(@PathVariable Long mentorId) throws Exception {
        return feedbackService.getFeedbackByMentorId(mentorId);
    }

}
