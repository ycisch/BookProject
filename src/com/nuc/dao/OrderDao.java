package com.nuc.dao;

import com.nuc.entiy.Order;
import com.nuc.entiy.Style;
import com.nuc.entiy.User;

import java.util.List;

public interface OrderDao {
    /**
     * 订单信息asdasdasdasd
     */

    //查看所有订单
    public List<Order> listOrder(User user);

    //查看所有类别
    public List<Style> listStyle();

    //添加类别
    public void addStyle(Style style);
}
