package com.nuc.dao;

import com.nuc.entiy.Order;
import com.nuc.entiy.Style;
import com.nuc.entiy.User;
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

    //查看所有订单
    public List<Order> listOrder(User user);

    //查看所有类别
    public List<Style> listStyle();

    //添加类别
    public void addStyle(Style style);
}
