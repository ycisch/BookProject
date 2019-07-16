package com.nuc.service;

import com.nuc.entiy.User;

public interface UserService {

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
    public boolean addMoney(User user, float money);

    //判断用户名是否存在
    public boolean exist(String username);
}
