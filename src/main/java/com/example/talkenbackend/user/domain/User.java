package com.example.talkenbackend.user.domain;

import com.example.talkenbackend.tag.domain.Tag;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String username;

    private String phone;
    private String introCaption; // 소개글
    private String category; // 직무 카테고리
    private String position; // 상세 직무

    private String profileImageUrl; // 프로필 사진 경로
    @OneToMany
    private List<Tag> tags = new ArrayList<>();

    @Builder
    public User(String email, String username, String profileImageUrl) {
        this.email = email;
        this.username = username;
        this.profileImageUrl = profileImageUrl;
    }


}
