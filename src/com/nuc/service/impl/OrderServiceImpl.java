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
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public boolean updateOrder(Order order, User uer) {
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
            System.out.println(style);
            if(style.getBookCategory().equals("1")){
                Date.MAP.add(style);
            }
            else{
                int index = style.getBookStyle().indexOf('_');
                String name = style.getBookStyle().substring(0,index);
                System.out.println(name+"@@@"+Date.MAP_TWO.containsKey(name));
                if(Date.MAP_TWO.containsKey(name)){

                    List<Style> list1_two = Date.MAP_TWO.get(name);
                    //System.out.println(list1_two.size());
                    list1_two.add(style);
                }
                else{
                    List<Style> list1_two = new ArrayList<>();
                    list1_two.add(style);
                   // System.out.println(name+"   "+list1_two.size());
                    Date.MAP_TWO.put(name,list1_two);
                }
            }
        }

        for (Map.Entry<String, List<Style>> entry : Date.MAP_TWO.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            for (Style style: entry.getValue()) {
                System.out.println(style);
            }
        }

        for (Style style : Date.MAP) {
            System.out.println(style);
        }

        return list;
    }

    @Override
    public void addStyle(Style style) {
        orderDao.addStyle(style);
    }
}
