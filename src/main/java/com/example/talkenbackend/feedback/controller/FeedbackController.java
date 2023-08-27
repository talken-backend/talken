package com.example.talkenbackend.feedback.controller;

import com.example.talkenbackend.feedback.dto.FeedbackRequestDto;
import com.example.talkenbackend.feedback.dto.FeedbackResponseDto;
import com.example.talkenbackend.feedback.service.FeedbackService;
import com.example.talkenbackend.global.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.talkenbackend.global.response.SuccessResponse.toResponseEntity;

@RequestMapping("/api/feedbacks")
@RequiredArgsConstructor
@RestController
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping("/{feedbackId}")
    public ResponseEntity<SuccessResponse<FeedbackResponseDto>> getFeedback(@PathVariable Long feedbackId) throws Exception {
        return toResponseEntity("피드백 단건 조회", feedbackService.getFeedback(feedbackId));
    }

    @GetMapping("mentee/{menteeId}") // menteeId는 User 테이블의 userId
    public ResponseEntity<SuccessResponse<List<FeedbackResponseDto>>> getFeedbackByMenteeId(@PathVariable Long menteeId) throws Exception {
        return toResponseEntity("멘티 아이디로 피드백 조회", feedbackService.getFeedbackByMenteeId(menteeId));
    }

    @GetMapping("mentor/{mentorId}")
    public ResponseEntity<SuccessResponse<List<FeedbackResponseDto>>> getFeedbackByMentorId(
            @PathVariable Long mentorId) throws Exception {
        return toResponseEntity("멘토 아이디로 피드백 조회", feedbackService.getFeedbackByMentorId(mentorId));
    }

    @DeleteMapping("/{feedbackId}")
    public ResponseEntity<SuccessResponse<String>> deleteFeedback(@PathVariable Long feedbackId) throws Exception {
        feedbackService.deleteFeedback(feedbackId);
        return toResponseEntity("피드백 삭제 성공");
    }

    @PutMapping("/{feedbackId}")
    public ResponseEntity<SuccessResponse<FeedbackResponseDto>> updateFeedback(
            @PathVariable Long feedbackId, @RequestBody FeedbackRequestDto dto) throws Exception {
        return toResponseEntity("피드백 수정 성공", feedbackService.updateFeedback(feedbackId, dto));
    }

    @PostMapping
    public ResponseEntity<SuccessResponse<FeedbackResponseDto>> createFeedback(@RequestBody FeedbackRequestDto dto) {
        return toResponseEntity("피드백 생성 성공", feedbackService.createFeedback(dto));
    }

}
