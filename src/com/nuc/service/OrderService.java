package com.nuc.service;

import com.nuc.entiy.Order;
import com.nuc.entiy.Style;
import com.nuc.entiy.User;

import java.util.List;

public interface OrderService {
    /**
     * 订单信息
     */



    //修改订单
    public boolean updateOrder(Order order,User uer);

    //删除订单
    public  boolean deleteOrder(Order order,User user);

    //查看所有订单
    public List<Order> listOrder(User user);

    //查看所有类别
    public List<Style> listStyle();

    //添加类别
    public void addStyle(Style style);

    //按个人查询所有订单总数
    public int sumOrder(User user);

    //计算订单总数
    public  int sumOrder();
}
