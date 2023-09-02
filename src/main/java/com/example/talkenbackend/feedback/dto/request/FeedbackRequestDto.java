package com.example.talkenbackend.feedback.dto.request;

import com.example.talkenbackend.feedback.domain.Feedback;
import lombok.Data;

@Data
public class FeedbackRequestDto {
    private Long mentorId;
    private Long menteeId;
    private Long portfolioId;

    private String content;

    public Feedback toEntity() {
        return Feedback.builder()
                .content(this.getContent())
                .portfolioId(this.getPortfolioId())
                .menteeId(this.getMenteeId())
                .mentorId(this.getMentorId())
                .build();
    }

}
