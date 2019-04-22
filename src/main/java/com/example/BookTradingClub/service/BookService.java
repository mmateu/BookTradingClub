package com.example.BookTradingClub.service;

import com.example.BookTradingClub.service.domain.Book;

import java.util.List;

public interface BookService {

    Book book(int id);

    List<Book> books();

    Book saveBook(Book book);


}
