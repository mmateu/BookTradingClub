package com.example.BookTradingClub.service;

import com.example.BookTradingClub.data.entity.BookEntity;
import com.example.BookTradingClub.data.repository.BookDataEntityRepository;
import com.example.BookTradingClub.service.domain.Book;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;


@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDataEntityRepository bookDataEntityRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public Book book(int id) {

        BookEntity bookEntity = bookDataEntityRepository.getBookEntity(id);

        return mapper.map(bookEntity, Book.class);
    }

    @Override
    public List<Book> books() {

        List<BookEntity> entities = bookDataEntityRepository.findBookEntities();

        Type bookListType = new TypeToken<List<Book>>(){}.getType();

        return mapper.map(entities, bookListType);
    }

    @Override
    public Book saveBook(Book book) {


        BookEntity bookEntity = mapper.map(book, BookEntity.class);

        bookEntity = bookDataEntityRepository.saveBook(bookEntity);

        return mapper.map(bookEntity, Book.class);

    }
}
