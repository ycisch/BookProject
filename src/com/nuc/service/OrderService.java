package com.nuc.service;

import com.nuc.entiy.Order;
import com.nuc.entiy.User;

import java.util.List;

public interface OrderService {
    /**
     * 订单信息
     */

    //查看所有订单
    public List<Order> listOrder(User user);

}