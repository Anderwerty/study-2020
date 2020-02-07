package com.bank;

import com.bank.entity.UserEntity;

public class Main {
    public static void main(String[] args) {
        final UserEntity userEntity1 = UserEntity.builder().withRole(null).build();
        final UserEntity userEntity2 = UserEntity.builder(userEntity1).withPassword("").build();
    }
}
