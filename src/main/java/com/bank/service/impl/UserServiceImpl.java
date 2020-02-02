package com.bank.service.impl;

import com.bank.dao.UserDao;
import com.bank.dao.domain.Page;
import com.bank.dao.domain.Pageable;
import com.bank.entity.UserEntity;
import com.bank.service.PasswordEncriptor;
import com.bank.service.UserService;
import com.bank.service.validator.Validator;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final int USER_PER_PAGE = 5;

    private final UserDao userRepository;
    private final PasswordEncriptor passwordEncriptor;
    private final Validator<UserEntity> userValidator;

    public UserServiceImpl(UserDao userRepository, PasswordEncriptor passwordEncriptor,
                           Validator<UserEntity> userValidator) {
        this.userRepository = userRepository;
        this.passwordEncriptor = passwordEncriptor;
        this.userValidator = userValidator;
    }

    @Override
    public boolean login(String email, String password) {
        //validate email and password
        String encriptPassword = passwordEncriptor.encript(password);

        return userRepository.findByEmail(email)
                .map(UserEntity::getPassword)
                .filter(pass -> pass.equals(encriptPassword))
                .isPresent();
    }

    @Override
    public UserEntity register(UserEntity userEntity) {
        userValidator.validate(userEntity);

        if (userRepository.findByEmail(userEntity.getEmail()).isPresent()) {
            throw new RuntimeException("message");
        }

        userRepository.save(userEntity);

        //id?
        return userEntity;
    }

    @Override
    public List<UserEntity> findAll(String page) {
        int pageNumber = 0;
        pageNumber = parsePageNumber(page, 0);

        //page should be validate or if page is not valid use default value 1 {-1,-2,...};
        //if page number> maxPage, maxPage
        final Pageable<UserEntity> users = userRepository.findAll(new Page(0, USER_PER_PAGE));
        return null;
    }

    private int parsePageNumber(String page, int defaultValue) {
        if (page == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(page);
        } catch (NumberFormatException e) {
            //log.warn
            return defaultValue;
        }
    }
}
