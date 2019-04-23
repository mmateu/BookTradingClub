package com.example.BookTradingClub.data.repository;

import com.example.BookTradingClub.data.entity.UserBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBookJPAEntityRepository extends JpaRepository<UserBookEntity, Integer>, EntityDataRepository<UserBookEntity>{
    @Override
    default UserBookEntity getEntity(int id) {
        return getOne(id);
    }

    @Override
    default List<UserBookEntity> findEntities() {
        return findAll();
    }

    @Override
    default UserBookEntity saveEntity(UserBookEntity userBookEntity) {
        return save(userBookEntity);
    }
}
