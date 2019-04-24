package com.example.BookTradingClub.presentation.dto;

import java.util.Objects;

/**
 * Class representing a Book in presentation layer.
 */
public class BookDto {
    private int id;

    private String author;

    private String title;

    public BookDto() {
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
        if (!(o instanceof BookDto)) return false;
        BookDto bookDto = (BookDto) o;
        return id == bookDto.id &&
                author.equals(bookDto.author) &&
                title.equals(bookDto.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title);
    }
}
