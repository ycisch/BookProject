package com.nuc;

import com.nuc.util.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {




    public static void main(String[] args) {
        BaseDao baseDao = new BaseDao();
        Connection connection = baseDao.getConn();
        String s = "select * from book";
        ResultSet rs = baseDao.executeQuery(s);
        try {
            while (rs.next()){
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
