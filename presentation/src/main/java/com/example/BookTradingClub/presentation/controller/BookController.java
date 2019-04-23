package com.example.BookTradingClub.presentation.controller;

import com.example.BookTradingClub.presentation.model.BookModel;
import com.example.BookTradingClub.service.BookService;
import com.example.BookTradingClub.service.domain.Book;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping(path= "/books")
public class BookController {

    private BookService bookService;

    private ModelMapper mapper;

    @Autowired
    public BookController(BookService bookService, ModelMapper modelMapper ){
        this.bookService = bookService;
        this.mapper = modelMapper;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    List<BookModel> getBooks(){

        List<Book> books = bookService.books();

        Type bookModelListType = new TypeToken<List<BookModel>>(){}.getType();

        return mapper.map(books, bookModelListType);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    BookModel getBook(@PathVariable(value = "id") final String id ){

        Book book = bookService.book(Integer.parseInt(id));

        return mapper.map(book,BookModel.class);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    BookModel saveBook(@RequestBody BookModel bookModel){

        Book book = mapper.map(bookModel, Book.class);

        return  mapper.map(bookService.saveBook(book), BookModel.class);

    }
}
