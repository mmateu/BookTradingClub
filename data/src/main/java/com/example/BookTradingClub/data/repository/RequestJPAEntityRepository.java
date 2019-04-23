package com.example.BookTradingClub.data.repository;

import com.example.BookTradingClub.data.entity.RequestEnity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestJPAEntityRepository extends JpaRepository<RequestEnity, Integer>, EntityDataRepository<RequestEnity> {

    @Override
    default RequestEnity getEntity(int id) {
        return getOne(id);
    }

    @Override
    default List<RequestEnity> findEntities() {
        return findAll();
    }

    @Override
    default RequestEnity saveEntity(RequestEnity requestEnity) {
        return save(requestEnity);
    }
}
