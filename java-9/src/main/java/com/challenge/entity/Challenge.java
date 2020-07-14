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
public class Challenge {

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

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "id.challenge")
    private List<Submission> submissions;

    @OneToMany(mappedBy = "challenge")
    private List<Acceleration> accelerations;

    /**
     * @deprecated (usado apenas pelo hibernate)
     */
    @Deprecated
    public Challenge() {
    }


    public Challenge(@Size(max = 100) String name, @Size(max = 50) String slug,
                     List<Submission> submissions, List<Acceleration> accelerations) {
        this.name = name;
        this.slug = slug;
        this.submissions = submissions;
        this.accelerations = accelerations;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public List<Acceleration> getAccelerations() {
        return accelerations;
    }

    public void setAccelerations(List<Acceleration> accelerations) {
        this.accelerations = accelerations;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}