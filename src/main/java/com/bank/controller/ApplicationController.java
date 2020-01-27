package com.bank.controller;

import com.bank.dao.UserDao;
import com.bank.view.ApplicationView;

public class ApplicationController {

    private final UserDao userDao;
    private final ApplicationView view;

    public ApplicationController(UserDao userDao, ApplicationView view) {
        this.userDao = userDao;
        this.view = view;
    }

    public void run() {
        while (true) {
            view.printMessage(" input your choose: 1- find by id, 2 - find by email 3-exit");
            int choose = view.readIntValue();
            switch (choose) {
                case 1:
                    findUserById();
                    break;
                case 2:
                    findUserByEmail();
                case 3:
                    System.exit(0);
            }
        }
    }

    private void findUserById() {
        view.printMessage("input id");
        Integer id = view.readIntValue();
        userDao.findById(id).ifPresent(view::printMessage);
    }

    private void findUserByEmail() {
        view.printMessage("input email");
        String email = view.readStringValue();
        userDao.findByEmail(email).ifPresent(view::printMessage);
    }
}
