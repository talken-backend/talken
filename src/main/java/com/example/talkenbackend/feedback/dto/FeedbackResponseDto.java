package com.example.talkenbackend.feedback.dto;

import com.example.talkenbackend.feedback.domain.Feedback;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FeedbackResponseDto {
    private Long id;
    private Long mentorId;
    private Long menteeId;
    private Long portfolioId;

    public static FeedbackResponseDto fromEntity(Feedback feedback) {
        return FeedbackResponseDto.builder()
                .id(feedback.getId())
                .mentorId(feedback.getMentorId())
                .menteeId(feedback.getMenteeId())
                .portfolioId(feedback.getPortfolioId())
                .build();
    }
}
