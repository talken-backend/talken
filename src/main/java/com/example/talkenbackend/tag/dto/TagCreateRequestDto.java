package com.example.talkenbackend.tag.dto;

import com.example.talkenbackend.tag.domain.Tag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TagCreateRequestDto {

    private String keyword;

    public Tag toEntity() {
        return Tag.builder()
                .keyword(keyword)
                .build();
    }
}
