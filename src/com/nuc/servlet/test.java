package com.nuc.servlet;

import com.nuc.service.OrderService;
import com.nuc.service.impl.OrderServiceImpl;
import com.nuc.util.Date;

import java.util.Map;

public class test {

    public static void main(String[] args) {

        OrderService orderService = new OrderServiceImpl();
        orderService.listStyle();

        for (Map.Entry<String, String> entry : Date.map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
    }
}
