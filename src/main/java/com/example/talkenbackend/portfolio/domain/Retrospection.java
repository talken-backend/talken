package com.example.talkenbackend.portfolio.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Retrospection {

    @Size(max = 100)
    @Column(columnDefinition = "TEXT")
    private String background;

    @Size(max = 100)
    @Column(columnDefinition = "TEXT")
    private String objective;

    @Size(max = 100)
    @Column(columnDefinition = "TEXT")
    private String detailRole;

    @Size(max = 300)
    @Column(columnDefinition = "TEXT")
    private String performance;

    @Size(max = 300)
    @Column(columnDefinition = "TEXT")
    private String improvement;

    public Retrospection(final String background, final String objective, final String detailRole,
                         final String performance, final String improvement) {
        this.background = background;
        this.objective = objective;
        this.detailRole = detailRole;
        this.performance = performance;
        this.improvement = improvement;
    }
}
