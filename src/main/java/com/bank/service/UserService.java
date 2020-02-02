package com.bank.service;

import com.bank.entity.UserEntity;

import java.util.List;

public interface UserService {

    boolean login(String email, String password);

    UserEntity register(UserEntity userEntity);

    //List<UserEntity> findAll(String page);
    List<UserEntity> findAll(String page);
}
