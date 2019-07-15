package com.nuc.service.impl;

import com.nuc.dao.AdminDao;
import com.nuc.dao.impl.AdminDaoImpl;
import com.nuc.entiy.Admin;
import com.nuc.entiy.User;
import com.nuc.service.AdminService;

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
    public List<User> listUser() {
        List<User> list = new ArrayList<>();
        list = dao.listUser();
        return list;
    }
}
