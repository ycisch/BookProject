package com.nuc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: ${NAME}
 * Function:  TODO
 * Date:      2019/7/17 23:28
 * author     Dell
 * version    V1.0
 */
public class WelcomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String opr = request.getParameter("opr");
        System.out.println(opr);
        if("welcome".equals(opr)){

            request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request,response);
        }
        else {
            System.out.println("Test");
            request.getRequestDispatcher("/WEB-INF/views/admin/list-user.jsp").forward(request,response);
        }

    }
}
