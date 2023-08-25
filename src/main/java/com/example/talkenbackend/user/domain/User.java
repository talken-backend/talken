package com.example.talkenbackend.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.validator.constraints.Email;

import java.util.ArrayList;
import java.util.List;

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

    private String profilePath; // 프로필 사진 경로
    @OneToMany
    private List<Tag> tags = new ArrayList<>();


}
