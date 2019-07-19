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

/**
 * ClassName: OrderServlet
 * Function:  查看所有订单   查询个人订单  修改订单  删除订单
 * Date:      2019/7/17 21:01
 * author     yinchen&wy&ry&wcr
 * version    V1.0
 */
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

        System.out.println(opr+"@@@@");

        /**
         * @description             二级关联---先取出一级标签
         */
        if(opr.equals("style")){
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            String str = JSON.toJSONString(Date.MAP);
            out.println(str);
            out.flush();
            out.close();
        }

        /**
         * @description             二级关联---取出二级标签
         */
        if(opr.equals("category")){
            String json = request.getParameter("field");
            List<Style> list = Date.MAP_TWO.get(json);
            for (Style style:list){
                System.out.println(style);
            }
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            String str = JSON.toJSONString(list);
            out.println(str);
            out.flush();
            out.close();
        }
        /**
         * @description             根据用户查询所有订单
         */
        if(opr.equals("list")){

            User user = (User) request.getSession().getAttribute("user");
            List<Order> list = orderService.listOrder(user);

            for(Order order1:list){
                order1.setUser(user);
                String name = order1.getBook().getBookimg().substring(2,order1.getBook().getBookimg().length());
                order1.getBook().setBookimg(name);
            }
            request.setAttribute("orderlist",list);
            request.getRequestDispatcher("/WEB-INF/order/order-user-list.jsp").forward(request,response);
        }
        /**
         * @description             查看所有用户的订单
         */
        if ("showAllusersorder".equals(opr)){
            orderList = orderService.listOrder();
            request.setAttribute("orderList",orderList);
            for(Order order1:orderList){
                String name = order1.getBook().getBookimg().substring(2,order1.getBook().getBookimg().length());
                order1.getBook().setBookimg(name);
            }
            request.getRequestDispatcher("/WEB-INF/views/order/order-list.jsp").forward(request,response);

        }
        /**
         * description              修改订单
         */
        if ("updateorder".equals(opr)){
            order = new Order();
            User user = (User) request.getSession().getAttribute("user");
            order.setOrderId(Integer.parseInt(request.getParameter("orderid")));
            order.setBooknum(Integer.parseInt(request.getParameter("booknum")));
            order.setMoney(Float.parseFloat(request.getParameter("money")));
            order.setUserId(Integer.parseInt(request.getParameter("userid")));


            if (orderService.updateOrder(order,user)){
                request.setAttribute("massage","修改成功！");
            }else {
                request.setAttribute("message", "修改失败！");
            }

            request.getRequestDispatcher("OrderServlet?opr=showAllusersorder").forward(request,response);


        }
        /**
         * 删除订单
         */
        if ("deleteorder".equals(opr)) {                                     //删除订单
            order = new Order();
            User user = (User) request.getSession().getAttribute("user");
            order.setOrderId(Integer.parseInt(request.getParameter("id")));
            order.setUserId(Integer.parseInt(request.getParameter("userid")));
            order.setMoney(Float.parseFloat(request.getParameter("money")));
            if (orderService.deleteOrder(order,user)){
                request.setAttribute("message","删除成功！");
            }else {
                request.setAttribute("message","删除失败！");
            }
            request.getRequestDispatcher("OrderServlet?opr=showAllusersorder").forward(request,response);
        }
        /**
         * @description             修改跳转过渡
         */
        if("updateto".equals(opr)){
            Order orderup = new Order();
            orderup.setOrderId(Integer.parseInt(request.getParameter("orderid")));
            orderup = orderService.selectOrder(orderup);
            request.setAttribute("orderup",orderup);
            request.getRequestDispatcher("/WEB-INF/views/order/order-update.jsp").forward(request,response);
        }

    }
}
