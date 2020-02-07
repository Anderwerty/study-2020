package com.bank.filter;

import com.bank.domain.Role;
import com.bank.domain.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        final HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");
        final Role role = user.getRole();
        if (role == Role.ADMIN) {
            chain.doFilter(request, response);
        } else {
            req.getRequestDispatcher("error_403.jsp").forward(request, response);
        }
    }
}
