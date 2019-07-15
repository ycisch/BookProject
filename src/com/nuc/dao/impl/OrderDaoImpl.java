package com.nuc.dao.impl;

import com.nuc.dao.OrderDao;
import com.nuc.entiy.Order;
import com.nuc.entiy.Style;
import com.nuc.entiy.User;
import com.nuc.util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    BaseDao baseDao = new BaseDao();

    @Override
    public List<Order> listOrder(User user) {
        String sql = "select * from order where userid = ?";
        Object params[] = {user.getId()};
        ResultSet rs = baseDao.executeQuery(sql,params);
        List<Order> list = new ArrayList<>();
        baseDao.commit();
        try{
            while (rs.next()){
                Order order = new Order();
                order.setBookId(rs.getInt(1));
                order.setBookId(rs.getInt(2));
                order.setBooknum(rs.getInt(3));
                order.setMoney(rs.getFloat(4));
                order.setUserId(rs.getInt(5));
                order.setCtdate(rs.getDate(6));
                list.add(order);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Style> listStyle() {
        String sql = "select * from style";
        List<Style> list = new ArrayList<>();

        ResultSet rs = baseDao.executeQuery(sql);
        baseDao.commit();
        //System.out.println(rs);
        try {
            while(rs.next()){
                Style style = new Style();
                style.setId(rs.getInt(1));
                style.setBookStyle(rs.getString(2));
                style.setBooksName(rs.getString(3));
                //System.out.println(style);
                list.add(style);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }


    //添加类别
    @Override
    public void addStyle(Style style) {

        String sql1 = "SELECT COUNT(DISTINCT bookstyle) from style";
        ResultSet rs = baseDao.executeQuery(sql1);
        int num = 0;
        try{
           while(rs.next()){
               num = rs.getInt(1);
           }
        }catch (SQLException e){
            e.printStackTrace();
        }
        String sql = "insert into style (bookstyle,booksname) values(?,?)";
        Object params[] = {num+1,style.getBooksName()};

        baseDao.executeUpdate(sql,params);

    }
}
