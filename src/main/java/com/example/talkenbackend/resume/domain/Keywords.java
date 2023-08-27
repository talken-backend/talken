package com.example.talkenbackend.resume.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Keywords {

    @ElementCollection
    @CollectionTable(joinColumns = @JoinColumn(name = "resume_id"))
    private List<Keyword> keywords = new ArrayList<>();

    public Keywords(final List<Keyword> keywords) {
        this.keywords = keywords;
    }
}
