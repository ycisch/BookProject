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
        }else if(opr.equals("list")){

            User user = (User) request.getSession().getAttribute("user");
            Page page = new Page();
            List<Order> list = orderService.listOrder(user,page);

            for(Order order1:list){
                order1.setUser(user);
                String name = order1.getBook().getBookimg().substring(2,order1.getBook().getBookimg().length());
                order1.getBook().setBookimg(name);
                System.out.println(order1);
            }
            request.setAttribute("orderlist",list);
            request.getRequestDispatcher("user/order.jsp").forward(request,response);
        }else if ("showAllusersorder".equals(opr)){                                          //展示所有人的订单

            System.out.println("Test");
            orderList = orderService.listOrder();
            request.setAttribute("orderlist",orderList);
            for(Order order1:orderList){
                String name = order1.getBook().getBookimg().substring(2,order1.getBook().getBookimg().length());
                order1.getBook().setBookimg(name);
                System.out.println(order1);
            }
            request.getRequestDispatcher("admin/admin_order.jsp").forward(request,response);

        }else if ("showMyorder".equals(opr)){                                         //展示自己的订单
           /* int currPageNo = Integer.parseInt(request.getParameter("page"));
            Page page = new Page();
            page.setTotalCount(orderService.sumOrder());
            if (currPageNo>= page.getTotalCount()){
                currPageNo = page.getTotalPageCout();
            }else if (currPageNo<=1){
                currPageNo = 1;
            }
            page.setCurrPageNo(currPageNo-1);
            order = new Order();*/
            orderList = orderService.listOrder();
            request.setAttribute("orderList",orderList);
            request.getRequestDispatcher("user/order.jsp").forward(request,response);


        }else if ("updateorder".equals(opr)){                                      //修改订单
            order = new Order();
            User user = (User) request.getSession().getAttribute("user");
            order.setOrderId(Integer.parseInt(request.getParameter("orderid")));
            //order.setBookId(Integer.parseInt(request.getParameter("bookId")));
            //order.setUserId(Integer.parseInt(request.getParameter("userId")));
            order.setBooknum(Integer.parseInt(request.getParameter("booknum")));
            order.setMoney(Float.parseFloat(request.getParameter("money")));
            order.setUserId(Integer.parseInt(request.getParameter("userid")));

            System.out.println(order+"@@@");

            if (orderService.updateOrder(order,user)){
                request.setAttribute("massage","修改成功！");
            }else {
                request.setAttribute("message", "修改失败！");
            }

            request.getRequestDispatcher("OrderServlet?opr=showAllusersorder").forward(request,response);


        }else if ("deleteorder".equals(opr)) {                                     //删除订单
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
        }else if("updateto".equals(opr)){
            Order orderup = new Order();

            orderup.setOrderId(Integer.parseInt(request.getParameter("id")));

            orderup = orderService.selectOrder(orderup);


            System.out.println(orderup);

            request.setAttribute("orderup",orderup);

            request.getRequestDispatcher("admin/admin_modifyorder.jsp").forward(request,response);
        }

    }
}
