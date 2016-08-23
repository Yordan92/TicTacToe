package com.tictactoe.filter;



import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tictactoe.services.CurrentUser;



@WebFilter({"/play.html", "/NewGamePlayServlet", "/ResumeGamePlayServlet"})
public class GameFilter implements Filter {

    @Inject
    CurrentUser currentUser;

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if (!isHttpCall(request, response)) {
            return;
        }
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
       
        if (currentUser.getUser() == null) {
            String loginUrl = httpServletRequest.getContextPath()
                    + "/login.html";
            httpServletResponse.sendRedirect(loginUrl);
            return;
        }
        chain.doFilter(request, response);
    }

    private boolean isHttpCall(ServletRequest request, ServletResponse response) {
        return (request instanceof HttpServletRequest)
                && (response instanceof HttpServletResponse);
    }

    public void destroy() {
    }

}