package com.example.BookTradingClub.service.domain;

import java.util.Objects;

public class UserBook {

    private int id;

    private UserWithoutDetails user;

    private Book book;

    private int count;

    public UserBook() {
    }

    public UserBook(int id, UserWithoutDetails user, Book book, int count) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserWithoutDetails getUser() {
        return user;
    }

    public void setUser(UserWithoutDetails user) {
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

    public boolean belongsToUserWithGivenUsername(String username) {
        return this.user.getName().equals(username);
    }

    public boolean availableToExchange() {
        return this.count > 0;
    }

    public void decrementCount(){
        this.count = this.count -1;
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
