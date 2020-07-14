package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Submission {

    @EmbeddedId
    private SubmissionId id;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @Column
    @NotNull
    private Float score;

    /**
     * @deprecated (Usado apenas pelo Hibernate)
     */
    @Deprecated
    public Submission() {
    }

    public Submission(Float score) {
        this.score = score;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}