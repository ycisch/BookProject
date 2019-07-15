package com.nuc.servlet;

import com.nuc.entiy.Book;
import com.nuc.entiy.User;
import com.nuc.service.OrderService;
import com.nuc.service.ShopService;
import com.nuc.service.impl.OrderServiceImpl;
import com.nuc.service.impl.ShopServiceImpl;
import com.nuc.util.Date;

import java.util.Map;

public class test {

    public static void main(String[] args) {

//        OrderService orderService = new OrderServiceImpl();
//        orderService.listStyle();
//
//        for (Map.Entry<String, String> entry : Date.map.entrySet()) {
//            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
//        }

        ShopService s1 = new ShopServiceImpl();

        Book book = new Book();
        User user = new User();

        book.setBookid(4);
        book.setBookNum(1);
        user.setId(1);



        s1.addShop(book,user);
    }
}
