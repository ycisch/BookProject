package com.nuc.servlet;

import com.alipay.api.domain.Data;
import com.nuc.entiy.Order;
import com.nuc.entiy.User;
import com.nuc.service.OrderService;
import com.nuc.service.impl.OrderServiceImpl;
import com.nuc.util.Date;
import com.nuc.util.Page;
import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.scene.chart.PieChart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        OrderService orderService = new OrderServiceImpl();
        Order order = null;
        User user = null;
        List<Order> orderList = new ArrayList<Order>();
        String opr = request.getParameter("opr");
        if ("showAllusersorder".equals(opr)){                                          //展示所有人的订单
           /* int currPageNo = Integer.parseInt(request.getParameter("page"));
            Page page = new Page();
            page.setTotalCount(orderService.sumOrder());
            if (currPageNo>= page.getTotalCount()){
                currPageNo = page.getTotalPageCout();
            }else if (currPageNo<=1){
                currPageNo = 1;
            }
            page.setCurrPageNo(currPageNo-1);*/
            orderList = orderService.listOrder();
            request.setAttribute("orderList",orderList);
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
           user = new User();
           order.setOrderId(Integer.parseInt(request.getParameter("orderId")));
           //order.setBookId(Integer.parseInt(request.getParameter("bookId")));
           //order.setUserId(Integer.parseInt(request.getParameter("userId")));
           order.setBooknum(Integer.parseInt(request.getParameter("bookNum")));
           order.setMoney(Float.parseFloat(request.getParameter("money")));




           if (orderService.updateOrder(order,user)){
               request.setAttribute("massage","修改成功！");
           }else {
               request.setAttribute("message", "修改失败！");
           }


        }else if ("deleteorder".equals(opr)) {                                     //删除订单
            order = new Order();
            user = new User();
            order.setOrderId(Integer.parseInt(request.getParameter("orderIde")));
            if (orderService.deleteOrder(order,user)){
                request.setAttribute("message","删除成功！");
            }else {
                request.setAttribute("message","删除失败！");
            }
        }
    }
}
