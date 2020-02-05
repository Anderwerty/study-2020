package com.bank.mapper;

import com.bank.domain.User;
import com.bank.entity.UserEntity;

public class UserMapper implements Mapper<UserEntity, User> {
    @Override
    public UserEntity mapDomainToEntity(User item) {
        return null;
    }

    @Override
    public User mapEntityToDomain(UserEntity enity) {
        return null;
    }
}
