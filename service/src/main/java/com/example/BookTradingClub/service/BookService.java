package com.example.BookTradingClub.service;

import com.example.BookTradingClub.service.domain.Book;
import com.example.BookTradingClub.service.domain.UserBook;

import java.util.List;

public interface BookService {

    Book book(int id);

    List<Book> books();

    List<UserBook> usersBooks();

    Book saveBook(Book book);


}
