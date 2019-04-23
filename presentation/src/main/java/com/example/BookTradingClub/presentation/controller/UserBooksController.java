package com.example.BookTradingClub.presentation.controller;

import com.example.BookTradingClub.presentation.model.UserBookModel;
import com.example.BookTradingClub.service.BookService;
import com.example.BookTradingClub.service.domain.UserBook;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping(path= "/user-books")
public class UserBooksController {

    @Autowired
    private
    BookService bookService;

    @Autowired
    private
    ModelMapper mapper;

    @RequestMapping(method = RequestMethod.GET)
    List<UserBookModel> getExistingUserBooks(){
        List<UserBook> books = bookService.usersBooks();

        Type userBookModelListType = new TypeToken<List<UserBookModel>>(){}.getType();

        return mapper.map(books, userBookModelListType);

    }
}
