package com.bank.service.impl;

import com.bank.entity.User;
import com.bank.dao.domain.Page;
import com.bank.dao.UserDao;
import com.bank.dao.domain.Pageable;
import com.bank.service.PasswordEncriptor;
import com.bank.service.UserService;
import com.bank.service.validator.Validator;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final int USER_PER_PAGE = 5;

    private final UserDao userRepository;
    private final PasswordEncriptor passwordEncriptor;
    private final Validator<User> userValidator;

    public UserServiceImpl(UserDao userRepository, PasswordEncriptor passwordEncriptor,
                           Validator<User> userValidator) {
        this.userRepository = userRepository;
        this.passwordEncriptor = passwordEncriptor;
        this.userValidator = userValidator;
    }

    @Override
    public boolean login(String email, String password) {
        //validate email and password
        String encriptPassword = passwordEncriptor.encript(password);

        return userRepository.findByEmail(email)
                .map(User::getPassword)
                .filter(pass -> pass.equals(encriptPassword))
                .isPresent();
    }

    @Override
    public User register(User user) {
        userValidator.validate(user);

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("message");
        }

        userRepository.save(user);

        //id?
        return user;
    }

    @Override
    public List<User> findAll(int page) {
        //page should be validate or if page is not valid use default value 1 {-1,-2,...};
        //if page number> maxPage, maxPage
        final Pageable<User> users = userRepository.findAll(new Page(page, USER_PER_PAGE));
        return null;
    }
}
