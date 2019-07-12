package com.nuc.servlet;

import com.nuc.util.FileUpload;

import java.io.IOException;

public class AdminServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println(request.getParameter("opr"));
        String s = FileUpload.getFileUpload(request.getSession().getServletContext().getRealPath("upload/"),request);
        System.out.println(s);
        response.sendRedirect("system/menu.jsp");
    }
}
