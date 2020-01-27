package com.bank.injector;

import com.bank.controller.ApplicationController;
import com.bank.dao.ConnectorDB;
import com.bank.dao.UserDao;
import com.bank.dao.impl.UserCrudDaoImpl;
import com.bank.view.ApplicationView;

import java.util.Scanner;

public class ContextInjector {
    private static final ConnectorDB CONNECTOR = new ConnectorDB("filename");
    private static final UserDao USER_CRUD_DAO = new UserCrudDaoImpl(CONNECTOR);
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ApplicationView APPLICATION_VIEW = new ApplicationView(SCANNER);

    private static final ApplicationController CONTROLLER = new ApplicationController(USER_CRUD_DAO, APPLICATION_VIEW);

    public static final ContextInjector INSTANCE = new ContextInjector();

    private ContextInjector() {

    }

    public ApplicationController getController() {
        return CONTROLLER;
    }
}
