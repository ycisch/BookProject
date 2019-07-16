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

    OrderDao dao = new OrderDaoImpl();

    @Override
    public boolean updateOrder(Order order, User user) {
        return dao.updateOrder(order,user);
    }

    @Override
    public boolean deleteOrder(Order order, User user) {
        return dao.deleteOrder(order, user);
    }

    @Override
    public List<Order> listOrder() {
        List<Order> list = new ArrayList<>();
        list = dao.listOrder();
        return list;
    }

    @Override
    public List<Order> listOrder(User user) {
        List<Order> list = new ArrayList<>();
        list = dao.listOrder(user);
        return list;
    }


    @Override
    public List<Style> listStyle() {
        List<Style> list = new ArrayList<>();
        list = dao.listStyle();
        for (Style style:list) {
            Date.map.put(style.getBooksName(),style.getBookStyle());
        }
        return list;
    }
    @Override
    public void addStyle(Style style) {
        dao.addStyle(style);
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
