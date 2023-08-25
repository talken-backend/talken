package com.example.talkenbackend.resume.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile {

    @Column
    private String image;

    @Column(nullable = false)
    private String field;   // 분야

    @Column(nullable = false)
    private String position;    // 직무

    @Column(columnDefinition = "TEXT")
    private String introduction;


    public Profile(final String image, final String field, final String position, final String introduction,
                   final List<Keyword> keywords) {
        this.image = image;
        this.field = field;
        this.position = position;
        this.introduction = introduction;
    }
}