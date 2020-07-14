package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CandidateId implements Serializable {

    @JoinColumn
    @ManyToOne
    private User user;

    @JoinColumn
    @ManyToOne
    private Acceleration acceleration;

    @JoinColumn
    @ManyToOne
    private Company company;


    /**
     * @deprecated (Usado apenas pelo Hibernate)
     */
    @Deprecated
    public CandidateId() {
    }

    public CandidateId(User user, Acceleration acceleration, Company company) {
        this.user = user;
        this.acceleration = acceleration;
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Acceleration getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Acceleration acceleration) {
        this.acceleration = acceleration;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CandidateId that = (CandidateId) object;
        return Objects.equals(user, that.user) &&
                Objects.equals(acceleration, that.acceleration) &&
                Objects.equals(company, that.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, acceleration, company);
    }
}
