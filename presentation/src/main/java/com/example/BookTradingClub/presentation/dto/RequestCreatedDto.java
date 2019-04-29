package com.example.BookTradingClub.presentation.dto;

import com.example.BookTradingClub.service.domain.UserBook;

import java.sql.Timestamp;
import java.util.Objects;

public class RequestCreatedDto {

    private  int id;

    private UserBook offeredBook;

    private UserBook wantedBook;

    private ExchangeState exchangeState;

    private Timestamp requestTimestamp;

    private Timestamp acceptDecisionTimestamp;

    public RequestCreatedDto() {
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
        if (!(o instanceof RequestCreatedDto)) return false;
        RequestCreatedDto that = (RequestCreatedDto) o;
        return id == that.id &&
                Objects.equals(offeredBook, that.offeredBook) &&
                Objects.equals(wantedBook, that.wantedBook) &&
                exchangeState == that.exchangeState &&
                Objects.equals(requestTimestamp, that.requestTimestamp) &&
                Objects.equals(acceptDecisionTimestamp, that.acceptDecisionTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, offeredBook, wantedBook, exchangeState, requestTimestamp, acceptDecisionTimestamp);
    }

    @Override
    public String toString() {
        return "RequestCreatedDto{" +
                "id=" + id +
                ", offeredBook=" + offeredBook +
                ", wantedBook=" + wantedBook +
                ", exchangeState=" + exchangeState +
                ", requestTimestamp=" + requestTimestamp +
                ", acceptDecisionTimestamp=" + acceptDecisionTimestamp +
                '}';
    }
}
