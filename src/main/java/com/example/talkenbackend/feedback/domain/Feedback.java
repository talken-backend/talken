package com.example.talkenbackend.feedback.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Feedback {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Long mentorId;
    @Column(nullable = false)
    private Long menteeId;
    @Column(nullable = false)
    private Long portfolioId;


}
