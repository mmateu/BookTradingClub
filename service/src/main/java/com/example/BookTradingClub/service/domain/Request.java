package com.example.BookTradingClub.service.domain;

import java.sql.Timestamp;
import java.util.Objects;

public class Request {

    private int id;

    private UserBook wantsToGive;

    private UserBook wantsToTake;

    private boolean accepted;

    private Timestamp requestTimestamp;

    private Timestamp acceptTimestamp;



    public Request() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserBook getWantsToGive() {
        return wantsToGive;
    }

    public void setWantsToGive(UserBook wantsToGive) {
        this.wantsToGive = wantsToGive;
    }

    public UserBook getWantsToTake() {
        return wantsToTake;
    }

    public void setWantsToTake(UserBook wantsToTake) {
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

    public Timestamp getAcceptTimestamp() {
        return acceptTimestamp;
    }

    public void setAcceptTimestamp(Timestamp acceptTimestamp) {
        this.acceptTimestamp = acceptTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return id == request.id &&
                Objects.equals(wantsToGive, request.wantsToGive) &&
                Objects.equals(wantsToTake, request.wantsToTake);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wantsToGive, wantsToTake);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", wantsToGive=" + wantsToGive +
                ", wantsToTake=" + wantsToTake +
                ", accepted=" + accepted +
                ", requestTimestamp=" + requestTimestamp +
                ", acceptTimestamp=" + acceptTimestamp +
                '}';
    }
}
