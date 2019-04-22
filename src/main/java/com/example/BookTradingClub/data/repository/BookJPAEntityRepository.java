package com.example.BookTradingClub.data.repository;

import com.example.BookTradingClub.data.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookJPAEntityRepository extends JpaRepository<BookEntity, Integer>, BookDataEntityRepository {

    @Override
    default public BookEntity getBookEntity(int id) {
        return getOne(id);
    }

    @Override
    default public List<BookEntity> findBookEntities() {
        return findAll();

    }

    @Override
    default BookEntity saveBook(BookEntity bookEntity) {
       return save(bookEntity);
    }
}
