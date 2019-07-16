package com.nuc.service.impl;

import com.nuc.dao.UserDao;
import com.nuc.dao.impl.UserDaoImpl;
import com.nuc.entiy.User;
import com.nuc.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public User login(User user) {
        User user1 = new User();
        user1 = dao.login(user);
        return user1;
    }

    @Override
    public boolean regist(User user) {
        boolean result = false;
        result = dao.regist(user);
        return result;
    }

    @Override
    public User getUser(User user) {
        User user1 = new User();
        user1 = dao.getUser(user);
        return user1;
    }

    @Override
    public User updateUser(User user) {
        User user1 = new User();
        user1 = dao.updateUser(user);
        return user1;
    }

    @Override
    public boolean addMoney(User user, float money) {
        boolean result = false;
        result = dao.addMoney(user, money);
        return result;
    }

    @Override
    public boolean exist(String username) {
        return dao.exist(username);
    }
}
