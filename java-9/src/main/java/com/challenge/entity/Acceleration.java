package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Acceleration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @Column(length = 100)
    @NotNull
    private String name;

    @Size(max = 50)
    @Column(length = 50)
    @NotNull
    private String slug;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", unique = true)
    private Challenge challenge;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "id.acceleration")
    private List<Candidate> candidates;

    /**
     * @deprecated (Usado apenas pelo Hibernate)
     */
    @Deprecated
    public Acceleration() {
    }

    public Acceleration(@Size(max = 100) String name, @Size String slug,
                        Challenge challenge, List<Candidate> candidates) {
        this.name = name;
        this.slug = slug;
        this.challenge = challenge;
        this.candidates = candidates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return "Acceleration{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", challenge=" + challenge +
                ", createdAt=" + createdAt +
                '}';
    }
}