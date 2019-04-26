package com.example.BookTradingClub.service.domain;

import java.util.Objects;

public class UserBook {

    private int id;

    private User user;

    private Book book;

    private int count;

    public UserBook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
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
        if (!(o instanceof UserBook)) return false;
        UserBook userBook = (UserBook) o;
        return id == userBook.id &&
                count == userBook.count &&
                Objects.equals(user, userBook.user) &&
                Objects.equals(book, userBook.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, book, count);
    }

    @Override
    public String toString() {
        return "UserBook{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", count=" + count +
                '}';
    }
}
