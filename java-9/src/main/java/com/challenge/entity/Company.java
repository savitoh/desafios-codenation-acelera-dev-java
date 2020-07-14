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
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(length = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    private String slug;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "id.company")
    private List<Candidate> candidates;

    /**
     * @deprecated (Usado apenas pelo Hibernate)
     */
    @Deprecated
    public Company() {
    }

    public Company(@Size(max = 100) String name, @Size(max = 50) String slug, List<Candidate> candidates) {
        this.name = name;
        this.slug = slug;
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
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}