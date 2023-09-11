package com.example.talkenbackend.feedback.domain;

import com.example.talkenbackend.feedback.dto.request.FeedbackRequestDto;
import com.example.talkenbackend.global.domain.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Feedback extends BaseTime {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Long mentorId;
    @Column(nullable = false)
    private Long menteeId;
    @Column(nullable = false)
    private Long portfolioId;

    private String content;


    public void update(FeedbackRequestDto dto) {
        this.content = dto.getContent();
    }
}
