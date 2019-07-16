package com.nuc.service.impl;

import com.nuc.dao.AdminDao;
import com.nuc.dao.impl.AdminDaoImpl;
import com.nuc.entiy.Admin;
import com.nuc.entiy.User;
import com.nuc.service.AdminService;
import com.nuc.util.Page;

import java.util.ArrayList;
import java.util.List;

public class AdmainServiceImpl implements AdminService {
    private AdminDao dao = new AdminDaoImpl();
    @Override
    public Admin login(Admin admin) {
        Admin admin1 = new Admin();
        admin1 = dao.login(admin);
        return admin1;
    }

    @Override
    public Admin getUser(Admin admin) {
        Admin admin1 = new Admin();
        admin1 = dao.getUser(admin);
        return admin1;
    }

    @Override
    public Admin updateUser(Admin admin) {
        Admin admin1 = new Admin();
        admin1 = dao.updateUser(admin);
        return admin1;
    }

    @Override
    public List<User> listUser(Page page) {
        List<User> list = new ArrayList<>();
        list = dao.listUser(page);
        return list;
    }

    public int userCount(){
        int userCount = 0;
        userCount = dao.userCount();
        return userCount;
    }

    @Override
    public boolean deleteUser(User user) {
        return dao.deleteUser(user);
    }
}
