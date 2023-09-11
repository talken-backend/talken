package com.example.talkenbackend.oauth.repository;

import com.example.talkenbackend.oauth.domain.SocialLoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocialLoginUserRepository extends JpaRepository<SocialLoginUser, Long> {
    Optional<SocialLoginUser> findByEmail(String email);
}
