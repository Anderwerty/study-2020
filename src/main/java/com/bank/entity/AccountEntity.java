package com.bank.entity;

public class AccountEntity {
    private final Integer id;
    private final String cardNumber;
    private final UserEntity user;
    private final Integer money;

    private AccountEntity(Builder builder) {
        this.id =builder. id;
        this.cardNumber=builder.cardNumber;
        this.user =builder. user;
        this.money =builder. money;
    }

    public static Builder builder(){
        return new Builder();
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

    public static class Builder {
        private Integer id;
        private String cardNumber;
        private UserEntity user;
        private Integer money;

        private Builder() {
        }

        public AccountEntity build(){
            return new AccountEntity(this);
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withCardNamber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public Builder withUser(UserEntity user) {
            this.user = user;
            return this;
        }

        public Builder withMoney(Integer money) {
            this.money = money;
            return this;
        }
    }
}
