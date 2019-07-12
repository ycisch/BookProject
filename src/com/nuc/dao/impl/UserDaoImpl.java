package com.nuc.dao.impl;

import com.nuc.dao.UserDao;
import com.nuc.entiy.User;
import com.nuc.util.BaseDao;
import com.nuc.util.DatabaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User login(User user) {
        BaseDao baseDao = new BaseDao();
        String sql = "SELECT * FROM 'user' WHERE 'username' = ? AND 'password' = ?";
        ResultSet rs = baseDao.executeQuery(sql, user.getUsername(), user.getPassword());
        try {
            if (rs.next())
                return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean regist(User user) {
        BaseDao baseDao = new BaseDao();
        String sql = "INSERT INTO 'user' " +
                "(username,password,email,address,phone,money,img)" +
                "VALUES (?,?,?,?,?,?,?)";
        if (user == null)   return false;
        int result = baseDao.executeUpdate(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getAddress(),user.getPhone(),user.getMoney(),user.getImg());
        return result > 0;
    }

    @Override
    public User getUser(User user) {
        BaseDao baseDao = new BaseDao();
        if (user == null)   return null;
        String sql = "SELECT * FROM 'user' WHERE 'id' = ?";
        ResultSet rs = baseDao.executeQuery(sql, user.getId());
        try {
            if (rs.next())
                return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String address = user.getAddress();
        String phone = user.getPhone();
        float money = user.getMoney();
        String img = user.getImg();

        BaseDao baseDao = new BaseDao();
        String sql = "UPDATE 'user' SET 'username'=?, 'password'=?, 'email'=?, 'address'=?, 'phone'=?, 'money'=?, 'img'=? WHERE ('id'=?)";


        return null;
    }

    @Override
    public boolean addMoney(User user, float money) {
        return false;
    }
}
