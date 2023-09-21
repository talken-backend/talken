package com.example.talkenbackend.share.repository;

import com.example.talkenbackend.share.domain.Share;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShareRepository extends JpaRepository<Share,Long> {
    Optional<Share> findByShareUrl(String shareUrl);

    Optional<Share> findByResumeId(Long resumeId);
}
