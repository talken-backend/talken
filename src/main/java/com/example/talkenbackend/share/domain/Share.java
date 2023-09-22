package com.example.talkenbackend.share.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Share {
    @Id @GeneratedValue
    private Long id;

    private String shareUrl;
    private Long resumeId;
}
