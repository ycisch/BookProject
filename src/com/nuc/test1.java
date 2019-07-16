package com.nuc;

import com.nuc.dao.AdminDao;
import com.nuc.dao.UserDao;
import com.nuc.dao.impl.AdminDaoImpl;
import com.nuc.dao.impl.UserDaoImpl;
import com.nuc.entiy.Admin;
import com.nuc.entiy.User;
import com.nuc.service.OrderService;
import com.nuc.service.impl.OrderServiceImpl;

public class test1 {
    public static void main(String[] args) {
//        AdminDao ad = new AdminDaoImpl();
//        Admin admin = new Admin();
//        UserDao ud = new UserDaoImpl();
//        User user = new User();
//        user.setId(1);
//        user.setUsername("wy");
//        user.setPassword("wy");
//        ud.login(user);
//        float money = 100;
//        ud.addMoney(user,money);
//        System.out.println(ud.getUser(user));

        OrderService orderService = new OrderServiceImpl();
        orderService.listStyle();

    }

}
