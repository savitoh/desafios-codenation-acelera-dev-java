package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "full_name", length = 100)
    private String fullName;

    @NotNull
    @Size(max = 50)
    @Column(name = "nick_name", length = 50)
    private String nickName;

    @Email
    @NotNull
    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @Size(max = 255)
    @NotNull
    @Column
    private String password;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "id.user")
    private List<Submission> submissions;

    @OneToMany(mappedBy = "id.user")
    private List<Candidate> candidates;

    /**
     * @deprecated (Usado apenas pelo Hibernate)
     */
    @Deprecated
    public User() {
    }

    public User(@Size(max = 100) String fullName, @Size(max = 50) String nickName,
                @Email @Size(max = 100) String email, @Size(max = 255) String password,
                List<Submission> submissions, List<Candidate> candidates) {
        this.fullName = fullName;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.submissions = submissions;
        this.candidates = candidates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}