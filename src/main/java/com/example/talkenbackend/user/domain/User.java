package com.example.talkenbackend.user.domain;

import com.example.talkenbackend.resume.domain.Resume;
import com.example.talkenbackend.tag.domain.Tag;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String passwordCheck;

    @Column(nullable = false)
    private String phone;

    @Enumerated(value = EnumType.STRING)
    private UserAuthority authority;

    private String introCaption; // 소개글
    private String category; // 직무 카테고리
    private String position; // 상세 직무

    private String profilePath; // 프로필 사진 경로
    @OneToMany
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Resume> resumes = new ArrayList<>();

    @Builder
    public User(String email, String username, String password, String passwordCheck, String phone, UserAuthority authority) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.phone = phone;
        this.authority = authority;
    }
}
