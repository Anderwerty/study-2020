package com.bank.repository;

import com.bank.domain.User;

import java.util.Optional;

public interface UserRepository extends CrudPageableRepository<User> {

    Optional<User> findByEmail(String email);
}
