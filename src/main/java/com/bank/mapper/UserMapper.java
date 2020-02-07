package com.bank.mapper;

import com.bank.domain.Role;
import com.bank.domain.User;
import com.bank.entity.RoleEntity;
import com.bank.entity.UserEntity;

import java.util.Optional;

public class UserMapper implements Mapper<UserEntity, User> {
    @Override
    public UserEntity mapDomainToEntity(User item) {
        return item == null ? null :
                UserEntity.builder()
                        .withRole(mapRole(item))
                        .withEmail(item.getEmail())
                        .build();
    }

    @Override
    public User mapEntityToDomain(UserEntity enity) {
        return null;
    }

    private RoleEntity mapRole(User item) {
        final Role role = item.getRole();
        RoleEntity.valueOfByName(role == null ? null : role.name());

        return RoleEntity.valueOfByName(Optional.ofNullable(item.getRole())
                .map(Enum::name)
                .orElse(null));
    }
}
