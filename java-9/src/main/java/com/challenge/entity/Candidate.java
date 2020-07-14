package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Candidate {

    @EmbeddedId
    private CandidateId id;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @Max(1)
    @NotNull
    @Column
    private Byte status;

    /**
     * @deprecated Usado apenas pelo Hibernate
     */
    @Deprecated
    public Candidate() {
    }

    public Candidate(@Max(1) Byte status) {
        this.status = status;
    }

    public CandidateId getId() {
        return id;
    }

    public void setId(CandidateId id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}