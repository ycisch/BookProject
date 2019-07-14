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
}
