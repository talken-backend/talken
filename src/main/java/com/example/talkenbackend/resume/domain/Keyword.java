package com.example.talkenbackend.resume.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Keyword {

    @Column(name = "keyword_id")
    private Long keywordId;

    @Column(nullable = false)
    private String content;


    public Keyword(String content) {
        this.content = content;
    }
}
