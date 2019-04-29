package com.example.BookTradingClub.presentation.dto;

import java.util.Objects;

public class RequestDecisionDto {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestDecisionDto)) return false;
        RequestDecisionDto that = (RequestDecisionDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RequestDecisionDto{" +
                "id=" + id +
                '}';
    }
}
