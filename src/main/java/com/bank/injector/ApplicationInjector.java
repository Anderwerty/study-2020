package com.bank.injector;

import com.bank.dao.ConnectorDB;
import com.bank.dao.UserDao;
import com.bank.dao.impl.UserCrudDaoImpl;
import com.bank.domain.User;
import com.bank.entity.UserEntity;
import com.bank.mapper.Mapper;
import com.bank.mapper.UserMapper;
import com.bank.service.PasswordEncriptor;
import com.bank.service.UserService;
import com.bank.service.impl.UserServiceImpl;
import com.bank.service.validator.UserValidator;
import com.bank.service.validator.Validator;

public class ApplicationInjector {

    private static final ApplicationInjector INSTANCE = new ApplicationInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final PasswordEncriptor PASSWORD_ENCRIPTOR = new PasswordEncriptor();

    private static final ConnectorDB CONNECTOR_DB = new ConnectorDB("database");

    private static final UserDao USER_REPOSITORY = new UserCrudDaoImpl(CONNECTOR_DB);

    private static final Mapper<UserEntity, User> USER_MAPPER = new UserMapper();

    private static final UserService USER_SERVICE = new UserServiceImpl(USER_REPOSITORY, PASSWORD_ENCRIPTOR, USER_VALIDATOR, USER_MAPPER);

    private ApplicationInjector() {
    }

    public static ApplicationInjector getInstance() {
        return INSTANCE;
    }

    public UserService getUserService() {
        return USER_SERVICE;
    }
}
