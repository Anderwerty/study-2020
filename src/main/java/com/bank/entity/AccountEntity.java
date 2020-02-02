package com.bank.entity;

public class AccountEntity {
    private final Integer id;
    private final UserEntity user;
    private final Integer money;

    public AccountEntity(Integer id, UserEntity user, Integer money) {
        this.id = id;
        this.user = user;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public Integer getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
