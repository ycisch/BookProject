package com.nuc.servlet;

import com.alibaba.fastjson.JSON;
import com.nuc.entiy.Order;
import com.nuc.entiy.Style;
import com.nuc.entiy.User;
import com.nuc.service.OrderService;
import com.nuc.service.impl.OrderServiceImpl;
import com.nuc.util.Date;
import com.nuc.util.Page;
import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //opr=list
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        request.setCharacterEncoding("UTF-8");

        OrderService orderService = new OrderServiceImpl();
        List<Order> orderList = new ArrayList<Order>();
        Order order = null;
        String opr = request.getParameter("opr");
        if(opr.equals("style")){
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            String str = JSON.toJSONString(Date.MAP);
            out.println(str);
            out.flush();
            out.close();
//            request.getSession().setAttribute("style", Date.MAP);
//            request.getSession().setAttribute("category",Date.MAP_TWO);
        }else if(opr.equals("category")){
            String json = request.getParameter("field");
            System.out.println(request.getParameter("field"));
            List<Style> list = Date.MAP_TWO.get(json);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            String str = JSON.toJSONString(list);
            out.println(str);
            out.flush();
            out.close();
        }

    }
}
