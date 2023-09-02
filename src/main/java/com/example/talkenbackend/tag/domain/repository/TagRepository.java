package com.example.talkenbackend.tag.domain.repository;

import com.example.talkenbackend.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    void deleteById(Long tagId);
}
