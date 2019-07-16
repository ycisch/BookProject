package com.nuc.service.impl;

import com.nuc.dao.OrderDao;
import com.nuc.dao.impl.OrderDaoImpl;
import com.nuc.entiy.Order;
import com.nuc.entiy.Style;
import com.nuc.entiy.User;
import com.nuc.service.OrderService;
import com.nuc.util.Date;
import com.nuc.util.Page;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public boolean updateOrder(Order order, User user) {
        return false;
    }

    @Override
    public boolean deleteOrder(Order order, User user) {
        return false;
    }

    @Override
    public List<Order> listOrder(User user) {
        return null;
    }

    @Override
    public List<Order> listOrder(Page page) {
        return null;
    }

    @Override
    public int sumOrder(Order order) {
        return 0;
    }

    @Override
    public int sumOrder() {
        return 0;
    }

    @Override
    public List<Style> listStyle() {
        List<Style> list = new ArrayList<>();
        list = orderDao.listStyle();
        for (Style style:list) {
            Date.map.put(style.getBooksName(),style.getBookStyle());
        }
        return list;
    }
    @Override
    public void addStyle(Style style) {
        orderDao.addStyle(style);
    }

    @Override
    public int sumOrder(Order order) {
        OrderDao orderDao = new OrderDaoImpl();
        return  orderDao.sumOrder();
    }

    @Override
    public int sumOrder() {
      int result = 0;
      OrderDao orderDao = new OrderDaoImpl();
      result = orderDao.sumOrder();
      return  result;
    }
}
