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
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        ResultSet rs = baseDao.executeQuery(sql, user.getUsername(), user.getPassword());
        try{
            while (rs.next()){
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString(4));
                user.setAddress(rs.getString(5));
                user.setPhone(rs.getString(6));
                user.setMoney(rs.getFloat(7));
                user.setImg(rs.getString(8));
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean regist(User user) {
        BaseDao baseDao = new BaseDao();
        String sql = "INSERT INTO user " +
                "(username,password,email,address,phone)" +
                "VALUES (?,?,?,?,?)";

        int result = baseDao.executeUpdate(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getAddress(),user.getPhone());
        baseDao.commit();
        return result > 0;
    }

    @Override
    public User getUser(User user) {
        BaseDao baseDao = new BaseDao();
        String sql = "SELECT * FROM user WHERE id = ?";
        ResultSet rs = baseDao.executeQuery(sql, user.getId());
        try {
            if (rs.next()){
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setAddress(rs.getString(5));
                user.setPhone(rs.getString(6));
                user.setMoney(rs.getFloat(7));
                user.setImg(rs.getString(8));
                baseDao.commit();
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        BaseDao baseDao = new BaseDao();
        String sql = "UPDATE user SET username=?, password=?, email=?, address=?, phone=? WHERE (id=?)";
        int result = baseDao.executeUpdate(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getAddress(), user.getPhone(), user.getId());
        baseDao.commit();
        return result > 0 ? user : null;
    }

    @Override
    public boolean addMoney(User user, float money) {
        BaseDao baseDao = new BaseDao();
        float newMoney = money + user.getMoney();
        String sql = "UPDATE user SET money=? WHERE id=?";
        int result = baseDao.executeUpdate(sql, newMoney, user.getId());
        baseDao.commit();
        return result > 0;
    }
}
