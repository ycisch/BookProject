package com.nuc.servlet;

import com.nuc.entiy.Book;
import com.nuc.entiy.Order;
import com.nuc.entiy.Style;
import com.nuc.entiy.User;
import com.nuc.service.OrderService;
import com.nuc.service.ShopService;
import com.nuc.service.impl.OrderServiceImpl;
import com.nuc.service.impl.ShopServiceImpl;
import com.nuc.util.Date;
import com.nuc.util.Page;

import java.util.List;
import java.util.Map;

public class test {

    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();

        User user = new User();
        user.setId(1);
        List<Order> list = orderService.listOrder(user);

        for(Order order:list){
            System.out.println(order);
        }

    }
}
