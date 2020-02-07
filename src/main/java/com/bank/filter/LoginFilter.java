package com.bank.filter;

import com.bank.domain.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;

        //what if session is null?
        final HttpSession session = req.getSession();
        if (session == null) {
            req.getRequestDispatcher("login.jsp").forward(req, response);
        } else {
            final User user = (User) session.getAttribute("user");
            if (user != null) {
                chain.doFilter(request, response);
            } else {
                req.getRequestDispatcher("login.jsp").forward(req, response);
            }
        }

    }
}
