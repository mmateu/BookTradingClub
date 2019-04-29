package com.example.BookTradingClub.presentation.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class RequestToCreateDto {

    private UserBookDto offeredBook;

    private UserBookDto wantedBook;

    public RequestToCreateDto() {
    }

    /*
        Using JsonCreator and JsonProperty annotations to make possible deserialization
        UserBookDtos out of integer constructor parameters injected through json body.
    */
    @JsonCreator
    public RequestToCreateDto(@JsonProperty("offeredBook") int offeredBookId, @JsonProperty("wantedBook") int wantedBookId) {
        this.offeredBook = new UserBookDto(offeredBookId);
        this.wantedBook = new UserBookDto(wantedBookId);
    }

    public UserBookDto getOfferedBook() {
        return offeredBook;
    }

    public void setOfferedBook(UserBookDto offeredBook) {
        this.offeredBook = offeredBook;
    }

    public UserBookDto getWantedBook() {
        return wantedBook;
    }

    public void setWantedBook(UserBookDto wantedBook) {
        this.wantedBook = wantedBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestToCreateDto)) return false;
        RequestToCreateDto that = (RequestToCreateDto) o;
        return Objects.equals(offeredBook, that.offeredBook) &&
                Objects.equals(wantedBook, that.wantedBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offeredBook, wantedBook);
    }
}
