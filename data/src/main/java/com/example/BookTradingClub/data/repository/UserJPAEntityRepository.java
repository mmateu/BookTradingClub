package com.example.BookTradingClub.data.repository;

import com.example.BookTradingClub.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJPAEntityRepository extends JpaRepository<UserEntity, Integer>, EntityDataRepository<UserEntity> {
    @Override
    default UserEntity getEntity(int id) {
        return getOne(id);
    }

    @Override
    default List<UserEntity> findEntities() {
        return findAll();
    }

    @Override
    default UserEntity saveEntity(UserEntity userEntity) {
        return save(userEntity);
    }

    UserEntity findByName(String name);
}
