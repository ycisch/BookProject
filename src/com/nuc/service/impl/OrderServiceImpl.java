package com.nuc.service.impl;

import com.nuc.dao.OrderDao;
import com.nuc.dao.impl.OrderDaoImpl;
import com.nuc.entiy.Order;
import com.nuc.entiy.Style;
import com.nuc.entiy.User;
import com.nuc.service.OrderService;
import com.nuc.util.BaseDao;
import com.nuc.util.Date;
import com.nuc.util.Page;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();

    //修改订单
    @Override
    public boolean updateOrder(Order order, User user) {
        boolean result = false;
        result = orderDao.updateOrder(order,user);
        return result;
    }

    //删除订单
    @Override
    public boolean deleteOrder(Order order, User user) {
        boolean result = false;
        result = orderDao.deleteOrder(order,user);
        return result;
    }

    //查看所有订单
    @Override
    public List<Order> listOrder(Page page) {
        List<Order> orderList = new ArrayList<Order>();
        orderList = orderDao.listOrder(page);
        return orderList;
    }

    //查看个人订单
    @Override
    public List<Order> listOrder(User user, Page page) {
        List<Order> orderList = new ArrayList<Order>();
        orderList = orderDao.listOrder(user,page);
        return orderList;
    }

    //按个人查询所有订单总数
    @Override
    public int sumOrder(Order order) {
        int result = 0;
        result = orderDao.sumOrder(order);
        return result;
    }

    //查询订单总数
    @Override
    public int sumOrder() {
        int result = 0;
        result = orderDao.sumOrder();
        return result;
    }

    //查看所有类别
    @Override
    public List<Style> listStyle() {
        List<Style> list = new ArrayList<>();
        list = orderDao.listStyle();
        for (Style style:list) {
            Date.map.put(style.getBooksName(),style.getBookStyle());
        }
        return list;
    }

    //添加类别
    @Override
    public void addStyle(Style style) {
        orderDao.addStyle(style);
    }
}
