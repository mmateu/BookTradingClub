package com.example.BookTradingClub.data.repository;

import com.example.BookTradingClub.data.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookJPAEntityRepository<T> extends JpaRepository<BookEntity, Integer>, EntityDataRepository<BookEntity> {

    @Override
    default public BookEntity getEntity(int id) {
        return getOne(id);
    }

    @Override
    default public List<BookEntity> findEntities() {
        return findAll();

    }

    @Override
    default BookEntity saveEntity(BookEntity bookEntity) {
       return save(bookEntity);
    }
}
