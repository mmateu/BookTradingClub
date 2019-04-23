package com.example.BookTradingClub.presentation.model;

import java.util.Objects;

public class UserBookModel {

    private int id;

    private UserModel user;

    private BookModel book;

    private int count;

    public UserBookModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
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
        if (!(o instanceof UserBookModel)) return false;
        UserBookModel that = (UserBookModel) o;
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
