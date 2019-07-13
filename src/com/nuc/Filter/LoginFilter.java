package com.nuc.Filter;

import com.nuc.entiy.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入过滤");
        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;



        HttpSession session = httpRequest.getSession();
        User user  = (User) session.getAttribute("user");
        if(user==null){
            System.out.println("用户没有登录");
//            httpServletResponse.sendRedirect("./system/login.jsp");
            String path = "system/login.jsp";
            httpRequest.getRequestDispatcher(path).forward(httpRequest,httpServletResponse);
        }
        else filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("摧毁");
    }
}
