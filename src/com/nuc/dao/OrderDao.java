package com.nuc.dao;

import com.nuc.entiy.Order;
import com.nuc.entiy.Style;
import com.nuc.entiy.User;
import com.nuc.util.Page;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public interface OrderDao {
    /**
     * 订单信息asdasdasdasd
     */

    //修改订单
    public boolean updateOrder(Order order,User uer);

    //删除订单
    public  boolean deleteOrder(Order order,User user);

    //查看个人订单
    public List<Order> listOrder(User user, Page page);

    //查看所有订单
    public List<Order> listOrder(Page page);

    //按个人查询所有订单总数
    public int sumOrder(Order order);

    //查询订单总数
    public int sumOrder();

    //查看所有类别
    public List<Style> listStyle();

    //添加类别
    public void addStyle(Style style);


    //查看个人订单
    public  int sumOrder(Order order);

    //查看所有订单
    public  int sumOrder();
}
