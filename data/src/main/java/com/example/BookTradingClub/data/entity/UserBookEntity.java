package com.example.BookTradingClub.data.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_books")
public class UserBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;

    private int count = 0;

    public UserBookEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
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
        if (!(o instanceof UserBookEntity)) return false;
        UserBookEntity that = (UserBookEntity) o;
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
