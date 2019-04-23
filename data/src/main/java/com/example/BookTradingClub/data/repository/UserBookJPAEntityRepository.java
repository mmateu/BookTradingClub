package com.example.BookTradingClub.data.repository;

import com.example.BookTradingClub.data.entity.UserBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
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
