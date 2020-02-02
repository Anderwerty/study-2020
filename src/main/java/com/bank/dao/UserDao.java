package com.bank.dao;

import com.bank.entity.UserEntity;

import java.util.Optional;

public interface UserDao extends CrudPageableDao<UserEntity> {

    Optional<UserEntity> findByEmail(String email);
}
