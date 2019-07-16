package com.nuc;

import com.nuc.dao.AdminDao;
import com.nuc.dao.impl.AdminDaoImpl;
import com.nuc.dao.impl.ShopDaoImpl;
import com.nuc.entiy.Admin;
import com.nuc.entiy.Shop;
import com.nuc.entiy.User;
import com.nuc.service.AdminService;
import com.nuc.service.impl.AdmainServiceImpl;
import com.nuc.util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.setAdminId(1);
        /*AdminDao adminDao = new AdminDaoImpl();
        admin = adminDao.getUser(admin);*/
//        AdminService adminService = new AdmainServiceImpl();
//        admin = adminService.getUser(admin);
//        System.out.println(admin.getAdminId());
//        System.out.println(admin.getAdminName());
//        System.out.println(admin.getAdminPwd());
        /*String sql = "select * from admin where adminid=?";
        ResultSet resultSet = new BaseDao().executeQuery(sql,admin.getAdminId());
        try{
            while (resultSet.next()){
                admin.setAdminId(resultSet.getInt("adminid"));
                System.out.println(admin.getAdminId());
                admin.setAdminName(resultSet.getString("adminname"));
                System.out.println(admin.getAdminName());
                admin.setAdminPwd(resultSet.getString("adminpwd"));
                System.out.println(admin.getAdminPwd());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }
}
