package com.example.talkenbackend.share.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ShareResponseDto {
    private String shareUrl;

    public static ShareResponseDto fromEntity(String shareUrl) {
        return ShareResponseDto.builder()
                .shareUrl(shareUrl)
                .build();
    }


}
