package com.bank.service.impl;

import com.bank.dao.UserDao;
import com.bank.dao.domain.Page;
import com.bank.dao.domain.Pageable;
import com.bank.domain.User;
import com.bank.entity.UserEntity;
import com.bank.mapper.Mapper;
import com.bank.service.PasswordEncriptor;
import com.bank.service.UserService;
import com.bank.service.validator.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private static final int USER_PER_PAGE = 5;

    private final UserDao userDao;
    private final PasswordEncriptor passwordEncriptor;
    private final Validator<User> userValidator;
    private final Mapper<UserEntity, User> userMapper;

    public UserServiceImpl(UserDao userDao, PasswordEncriptor passwordEncriptor,
                           Validator<User> userValidator, Mapper<UserEntity, User> userMapper) {
        this.userDao = userDao;
        this.passwordEncriptor = passwordEncriptor;
        this.userValidator = userValidator;
        this.userMapper = userMapper;
    }

    @Override
    public boolean login(String email, String password) {
        //validate email and password
        String encriptPassword = passwordEncriptor.encript(password);

        return userDao.findByEmail(email)
                .map(UserEntity::getPassword)
                .filter(pass -> pass.equals(encriptPassword))
                .isPresent();
    }

    @Override
    public User register(User user) {
        userValidator.validate(user);

        if (userDao.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("message");
        }

        // user --> userEntity
        final UserEntity userEntity = userMapper.mapDomainToEntity(user);
        userDao.save(userEntity);

        //id?
        return user;
    }

    @Override
    public List<User> findAll(String page) {
        int pageNumber = 0;
        pageNumber = parsePageNumber(page, 0);

        //page should be validate or if page is not valid use default value 1 {-1,-2,...};
        //if page number> maxPage, maxPage
        final Pageable<UserEntity> userEntityPageable =
                userDao.findAll(new Page(0, USER_PER_PAGE));

        return userEntityPageable.getItems().stream()
                .map(userMapper::mapEntityToDomain)
                .collect(Collectors.toList());
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
