package com.nuc.dao.impl;

import com.nuc.dao.OrderDao;
import com.nuc.entiy.Order;
import com.nuc.entiy.Style;
import com.nuc.entiy.User;
import com.nuc.util.BaseDao;
import com.nuc.util.DatabaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    BaseDao baseDao = new BaseDao();

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

    @Override
    public int sumOrder(User user) {
        String sql = "select * from order where userid = ?";
        Object params[] = null;
        BaseDao baseDao = new BaseDao();
        if ("id".equals(user.getList_order())){
            sql = "select COUNT(*) FROM order where userid = ?";
        }else if ("name".equals(user.getList_order())){
            sql = "select COUNT(*) FROM order where bookname = ?";
        }else if ("date".equals(user.getList_order())){
            sql = "select COUNT(*) FROM order where ctdate = ?";
        }
        params = new Object[]{user.getList_order()};
        ResultSet rs = baseDao.executeQuery(sql,params);
        int ans = 0;
        try {
            while (rs.next()){
                ans = rs.getInt(1);
            }
            baseDao.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeAll(null,null,rs);
        }
        return ans;
    }

    @Override
    public int sumOrder() {
        int result = 0;
        ResultSet resultSet = null;
        String sql = "select count(*) from order";
        BaseDao baseDao = new BaseDao();
        try {
            resultSet = baseDao.executeQuery(sql);
            while (resultSet.next()){
                result = resultSet.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeAll(null,null,resultSet);
        }

        return result;
    }
}
