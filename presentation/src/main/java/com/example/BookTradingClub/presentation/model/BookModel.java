package com.example.BookTradingClub.presentation.model;

import java.util.Objects;

/**
 * Class representing a Book in presentation layer.
 */
public class BookModel {
    private int id;

    private String author;

    private String title;

    public BookModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookModel)) return false;
        BookModel bookModel = (BookModel) o;
        return id == bookModel.id &&
                author.equals(bookModel.author) &&
                title.equals(bookModel.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title);
    }
}
