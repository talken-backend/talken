package com.example.talkenbackend.resume.dto.response;

import com.example.talkenbackend.resume.domain.ProfileImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileImageResponseDto {

    private String imageUrl;

    @Builder
    public ProfileImageResponseDto(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static ProfileImageResponseDto fromEntity(ProfileImage profileImage) {
        return ProfileImageResponseDto.builder()
                .imageUrl(profileImage.getImage().getImageUrl())
                .build();
    }
}
