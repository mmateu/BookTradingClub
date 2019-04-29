package com.example.BookTradingClub.service.domain;

import java.sql.Timestamp;
import java.util.Objects;

public class Request {

    private int id;

    private UserBook offeredBook;

    private UserBook wantedBook;

    private ExchangeState exchangeState;

    private Timestamp requestTimestamp;

    private Timestamp acceptDecisionTimestamp;

    public Request(){
    }


    public Request(int id, UserBook offeredBook, UserBook wantedBook, ExchangeState exchangeState, Timestamp requestTimestamp, Timestamp acceptDecisionTimestamp) {
        this.id = id;
        this.offeredBook = offeredBook;
        this.wantedBook = wantedBook;
        this.exchangeState = exchangeState;
        this.requestTimestamp = requestTimestamp;
        this.acceptDecisionTimestamp = acceptDecisionTimestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserBook getOfferedBook() {
        return offeredBook;
    }

    public void setOfferedBook(UserBook offeredBook) {
        this.offeredBook = offeredBook;
    }

    public UserBook getWantedBook() {
        return wantedBook;
    }

    public void setWantedBook(UserBook wantedBook) {
        this.wantedBook = wantedBook;
    }

    public ExchangeState getExchangeState() {
        return exchangeState;
    }

    public void setExchangeState(ExchangeState exchangeState) {
        this.exchangeState = exchangeState;
    }

    public Timestamp getRequestTimestamp() {
        return requestTimestamp;
    }

    public void setRequestTimestamp(Timestamp requestTimestamp) {
        this.requestTimestamp = requestTimestamp;
    }

    public Timestamp getAcceptDecisionTimestamp() {
        return acceptDecisionTimestamp;
    }

    public void setAcceptDecisionTimestamp(Timestamp acceptDecisionTimestamp) {
        this.acceptDecisionTimestamp = acceptDecisionTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return id == request.id &&
                Objects.equals(offeredBook, request.offeredBook) &&
                Objects.equals(wantedBook, request.wantedBook) &&
                exchangeState == request.exchangeState &&
                Objects.equals(requestTimestamp, request.requestTimestamp) &&
                Objects.equals(acceptDecisionTimestamp, request.acceptDecisionTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, offeredBook, wantedBook, exchangeState, requestTimestamp, acceptDecisionTimestamp);
    }
}
