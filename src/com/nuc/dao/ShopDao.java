package com.nuc.dao;

import com.nuc.entiy.Book;
import com.nuc.entiy.Shop;
import com.nuc.entiy.User;

import java.util.Date;
import java.util.List;

public interface ShopDao {
    //购物车功能
    //查看所有购物信息
    public List<Shop> listShop(User user);

    //用户添加商品到购物车
    public boolean addShop(Book book, User user);

    //用户删除购物车商品
    public boolean deleteShop(Shop shop, User user);

    //用户修改购物车商品
    public boolean updateShop(Shop shop, User user);

    //用户结算购物车
    public boolean sumMoney(User user, String ids[]);
}
