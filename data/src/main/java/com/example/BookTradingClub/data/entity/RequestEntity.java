package com.example.BookTradingClub.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "requests")
public class RequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(nullable = false)
    private UserBookEntity offeredBook;

    @OneToOne
    @JoinColumn(nullable = false)
    private UserBookEntity wantedBook;

    @Enumerated(EnumType.STRING)
    @Column(name = "exchange_state")
    private ExchangeState exchangeState;

    @Column(name = "request_timestamp", nullable = false)
    private Timestamp requestTimestamp;

    @Column(name = "accept_decision_timestamp")
    private Timestamp acceptDecisionTimestamp;

    public RequestEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserBookEntity getOfferedBook() {
        return offeredBook;
    }

    public void setOfferedBook(UserBookEntity offeredBook) {
        this.offeredBook = offeredBook;
    }

    public UserBookEntity getWantedBook() {
        return wantedBook;
    }

    public void setWantedBook(UserBookEntity wantedBook) {
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
        if (!(o instanceof RequestEntity)) return false;
        RequestEntity that = (RequestEntity) o;
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
}
