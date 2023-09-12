package com.example.talkenbackend.resume.domain;

import com.example.talkenbackend.image.domain.Image;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @Builder
    public ProfileImage(Resume resume, Image image) {
        this.resume = resume;
        this.image = image;
    }
}
