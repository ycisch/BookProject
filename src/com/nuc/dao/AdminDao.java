package com.nuc.dao;

import com.nuc.entiy.Admin;
import com.nuc.entiy.User;
import com.nuc.util.Page;

import java.util.List;

public interface AdminDao {
    /**
     * 管理员功能描述
     */

    //管理员登录功能
    public Admin login(Admin admin);

    //个人信息查看
    public Admin getUser(Admin admin);

    //个人信息修改
    public Admin updateUser(Admin admin);

    //查看所有用户
    public List<User> listUser(Page page);

    //得到总用户数
    public int userCount();

    //删除用户
    public boolean deleteUser(User user);
}
