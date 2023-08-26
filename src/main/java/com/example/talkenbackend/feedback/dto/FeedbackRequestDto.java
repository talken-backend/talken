package com.example.talkenbackend.feedback.dto;

import lombok.Data;

@Data
public class FeedbackRequestDto {
    private Long mentorId;
    private Long menteeId;
    private Long portfolioId;

    private String content;

}
