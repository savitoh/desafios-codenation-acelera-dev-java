package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SubmissionId  implements Serializable {

    @JoinColumn
    @ManyToOne
    private User user;

    @JoinColumn
    @ManyToOne
    private Challenge challenge;

    public SubmissionId(User user, Challenge challenge) {
        this.user = user;
        this.challenge = challenge;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SubmissionId that = (SubmissionId) object;
        return Objects.equals(user, that.user) &&
                Objects.equals(challenge, that.challenge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, challenge);
    }
}
