package com.example.BookTradingClub.data.repository;

import com.example.BookTradingClub.data.entity.BookEntity;
import java.util.List;


public interface BookDataEntityRepository {

    BookEntity getBookEntity(int id);
    List<BookEntity> findBookEntities();
    BookEntity saveBook(BookEntity bookEntity);


}
