package com.example.BookTradingClub.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "requests")
public class RequestEnity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(nullable = false)
    private UserBookEntity wantsToGive;

    @OneToOne
    @JoinColumn(nullable = false)
    private UserBookEntity wantsToTake;

    private boolean accepted = false;

    @Column(name = "request_timestamp", nullable = false)
    private Timestamp requestTimestamp;

    @Column(name = "accept_timestamp")
    private Timestamp accept_timestamp;

    public RequestEnity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserBookEntity getWantsToGive() {
        return wantsToGive;
    }

    public void setWantsToGive(UserBookEntity wantsToGive) {
        this.wantsToGive = wantsToGive;
    }

    public UserBookEntity getWantsToTake() {
        return wantsToTake;
    }

    public void setWantsToTake(UserBookEntity wantsToTake) {
        this.wantsToTake = wantsToTake;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Timestamp getRequestTimestamp() {
        return requestTimestamp;
    }

    public void setRequestTimestamp(Timestamp requestTimestamp) {
        this.requestTimestamp = requestTimestamp;
    }

    public Timestamp getAccept_timestamp() {
        return accept_timestamp;
    }

    public void setAccept_timestamp(Timestamp accept_timestamp) {
        this.accept_timestamp = accept_timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestEnity)) return false;
        RequestEnity that = (RequestEnity) o;
        return id == that.id &&
                accepted == that.accepted &&
                Objects.equals(wantsToGive, that.wantsToGive) &&
                Objects.equals(wantsToTake, that.wantsToTake) &&
                Objects.equals(requestTimestamp, that.requestTimestamp) &&
                Objects.equals(accept_timestamp, that.accept_timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wantsToGive, wantsToTake, accepted, requestTimestamp, accept_timestamp);
    }
}
