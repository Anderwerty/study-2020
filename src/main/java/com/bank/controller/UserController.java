package com.bank.controller;

import com.bank.domain.User;
import com.bank.injector.ApplicationInjector;
import com.bank.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController extends HttpServlet {
    private final UserService userService;

    public UserController() {
        ApplicationInjector injector = ApplicationInjector.getInstance();
        this.userService = injector.getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //page

        final String page =(String) req.getAttribute("page");


        final String email = (String) req.getSession().getAttribute("email");
        final String password = (String) req.getSession().getAttribute("password");

        final boolean isLogin = userService.login(email, password);
        if (isLogin) {
            req.getRequestDispatcher("user.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }
}
