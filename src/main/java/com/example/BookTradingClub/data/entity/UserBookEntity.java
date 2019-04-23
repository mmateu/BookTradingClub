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
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity bookEntity;

    private int count = 0;

    public UserBookEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
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
                Objects.equals(userEntity, that.userEntity) &&
                Objects.equals(bookEntity, that.bookEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userEntity, bookEntity, count);
    }
}
