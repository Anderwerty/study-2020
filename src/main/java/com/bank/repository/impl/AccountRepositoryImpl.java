package com.bank.repository.impl;

import com.bank.domain.Account;
import com.bank.repository.AccountRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {
    //
    @Override
    public void save(Account entity) {

    }

    @Override
    public Optional<Account> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Account> findAll() {
        return Collections.emptyList();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void update(Account entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
