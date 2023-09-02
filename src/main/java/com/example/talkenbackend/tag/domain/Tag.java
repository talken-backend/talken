package com.example.talkenbackend.tag.domain;

import com.example.talkenbackend.tag.dto.TagRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String keyword;

    @Builder
    public Tag(String keyword) {
        this.keyword = keyword;
    }

    public void update(TagRequestDto tagRequest) {
        this.keyword = tagRequest.getKeyword();
    }
}
