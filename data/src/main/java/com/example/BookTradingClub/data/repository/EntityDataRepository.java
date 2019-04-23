package com.example.BookTradingClub.data.repository;

import java.util.List;

public interface EntityDataRepository<T> {
    T getEntity(int id);
    List<T> findEntities();
    T saveEntity(T t);
}
