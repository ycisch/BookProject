package com.nuc.dao;

import com.nuc.entiy.User;

public interface UserDao {
    /**
     * 用户功能描述
     */

    //用户登录功能
    public User login(User user);

    //用户注册
    public boolean regist(User user);

    //个人信息查看
    public User getUser(User user);

    //个人信息修改
    public User updateUser(User user);

    //余额充值
    public boolean addMoney(User user,float money);

}