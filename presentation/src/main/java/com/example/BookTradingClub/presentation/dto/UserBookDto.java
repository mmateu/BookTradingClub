package com.example.BookTradingClub.presentation.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UserBookDto {

    private  int id;

    private UserWithoutDetailsDto user;

    private BookDto book;

    private int count;

    public UserBookDto() {
    }

    @JsonCreator
    public UserBookDto(@JsonProperty("id") int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserWithoutDetailsDto getUser() {
        return user;
    }

    public void setUser(UserWithoutDetailsDto user) {
        this.user = user;
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBookDto)) return false;
        UserBookDto that = (UserBookDto) o;
        return id == that.id &&
                count == that.count &&
                Objects.equals(user, that.user) &&
                Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, book, count);
    }
}
