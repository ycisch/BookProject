package com.nuc.dao.impl;

import com.nuc.dao.AdminDao;
import com.nuc.entiy.Admin;
import com.nuc.entiy.User;
import com.nuc.util.BaseDao;
import com.nuc.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin login(Admin admin) {
        BaseDao baseDao = new BaseDao();
        String sql = "SELECT * FROM admin WHERE adminname=? AND adminpwd=?";
        ResultSet rs = baseDao.executeQuery(sql, admin.getAdminName(), admin.getAdminPwd());
        try {
            while (rs.next()){
                admin.setAdminId(rs.getInt(1));
                return admin;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Admin getUser(Admin admin) {
        BaseDao baseDao = new BaseDao();
        String sql = "SELECT * FROM admin WHERE adminid=?";
        ResultSet rs = baseDao.executeQuery(sql, admin.getAdminId());
        try {
            if (rs.next())
            {
                admin.setAdminName(rs.getString(2));
                admin.setAdminPwd(rs.getString(3));
                baseDao.commit();
                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Admin updateUser(Admin admin) {
        System.out.println(admin);
        BaseDao baseDao = new BaseDao();
        String sql = "UPDATE admin SET adminname=?, adminpwd=? WHERE adminid=?";
        int result = baseDao.executeUpdate(sql, admin.getAdminName(), admin.getAdminPwd(), admin.getAdminId());
        baseDao.commit();
        System.out.println(admin);
        return result > 0 ? admin : null;
    }

    @Override
    public List<User> listUser(Page page) {
        BaseDao baseDao = new BaseDao();
        String sql = "SELECT * FROM user LIMIT ?,?";
        List<User> list = new ArrayList<>();
        ResultSet rs = baseDao.executeQuery(sql, (page.getCurrPageNo() - 1) * page.getPageSize(), page.getPageSize());
        try{
            while (rs.next())
            {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setAddress(rs.getString(5));
                user.setPhone(rs.getString(6));
                user.setMoney(rs.getFloat(7));
                user.setImg(rs.getString(8));
                list.add(user);
            }
            baseDao.commit();
            return list;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public int userCount(){
        BaseDao baseDao = new BaseDao();
        int userCount = 0;
        String sql = "SELECT COUNT(id) FROM user ";
        ResultSet rs = baseDao.executeQuery(sql);
        try{
            while (rs.next()){
                userCount = rs.getInt(1);
                baseDao.commit();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return userCount;
    }

    @Override
    public boolean deleteUser(User user) {
        BaseDao baseDao = new BaseDao();
        String sql = "DELETE FROM user WHERE id=?";
        int result = baseDao.executeUpdate(sql, user.getId());
        baseDao.commit();
        return result > 0;
    }
}
