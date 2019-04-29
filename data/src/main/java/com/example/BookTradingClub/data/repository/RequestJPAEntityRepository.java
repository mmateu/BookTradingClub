package com.example.BookTradingClub.data.repository;

import com.example.BookTradingClub.data.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestJPAEntityRepository extends JpaRepository<RequestEntity, Integer>, EntityDataRepository<RequestEntity> {

    @Override
    default RequestEntity getEntity(int id) {
        return getOne(id);
    }

    @Override
    default List<RequestEntity> findEntities() {
        return findAll();
    }

    @Override
    default RequestEntity saveEntity(RequestEntity requestEntity) {
        return save(requestEntity);
    }
}
