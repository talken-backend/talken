package com.example.talkenbackend.image.domain.repository;

import com.example.talkenbackend.image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
