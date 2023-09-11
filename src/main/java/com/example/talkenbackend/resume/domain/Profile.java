package com.example.talkenbackend.resume.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile {

    @Column
    private String image;

    @Column(nullable = false)
    private String field;   // 분야

    @Column(nullable = false)
    private String position;    // 직무

    @Column(columnDefinition = "TEXT")
    private String introduction;

    private boolean emailStatus = true;

    private boolean phoneStatus = false;


    public Profile(final String image, final String field, final String position, final String introduction,
                   final boolean emailStatus, final boolean phoneStatus) {
        this.image = image;
        this.field = field;
        this.position = position;
        this.introduction = introduction;
        this.emailStatus = emailStatus;
        this.phoneStatus = phoneStatus;
    }
}