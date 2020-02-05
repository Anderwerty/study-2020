package com.bank.service;

import com.bank.domain.User;
import com.bank.entity.UserEntity;

import java.util.List;

public interface UserService {

    boolean login(String email, String password);

    User register(User user);

    //List<UserEntity> findAll(String page);
    List<User> findAll(String page);
}
