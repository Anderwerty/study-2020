package com.bank.entity;

import java.util.List;
import java.util.Objects;

import static com.bank.utility.CollectionUtility.nullSafeListInitialize;

public class UserEntity {
    private final Integer id;
    private final String email;
    private final String password;
    private final String telephoneNumber;
    private final List<AccountEntity> accountEntities;

    private UserEntity(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.password = builder.password;
        this.telephoneNumber = builder.telephoneNumber;
        this.accountEntities = nullSafeListInitialize(builder.accountEntities);
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<AccountEntity> getAccountEntities() {
        return accountEntities;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(id, userEntity.id) &&
                Objects.equals(email, userEntity.email) &&
                Objects.equals(password, userEntity.password) &&
                Objects.equals(accountEntities, userEntity.accountEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, accountEntities);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + "[********]" + '\'' +
                ", accountEntities=" + accountEntities +
                '}';
    }

    public static class Builder {
        private Integer id;
        private String email;
        private String password;
        private String telephoneNumber;
        private List<AccountEntity> accountEntities;

        private Builder() {
        }

        public UserEntity build() {
            return new UserEntity(this);
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public Builder withAccounts(List<AccountEntity> accountEntities) {
            this.accountEntities = accountEntities;
            return this;
        }
    }
}
