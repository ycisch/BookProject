package com.nuc;

import com.nuc.dao.AdminDao;
import com.nuc.dao.OrderDao;
import com.nuc.dao.impl.AdminDaoImpl;
import com.nuc.dao.impl.OrderDaoImpl;
import com.nuc.dao.impl.ShopDaoImpl;
import com.nuc.entiy.Admin;
import com.nuc.entiy.Order;
import com.nuc.entiy.Shop;
import com.nuc.entiy.User;
import com.nuc.service.AdminService;
import com.nuc.service.impl.AdmainServiceImpl;
import com.nuc.util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        OrderDao orderDao = new OrderDaoImpl();
        Order order = new Order();
        User user = new User();
        user.setId(1);
        order.setOrderId(100);
        order.setUserId(1);
        order.setMoney(1100);
        //order.setBooknum(3);
        boolean result = false;
        result = orderDao.deleteOrder(order,user);
        System.out.println(result);


    }
}
