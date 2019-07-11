package com.nuc.dao.impl;

import com.nuc.dao.ShopDao;
import com.nuc.entiy.Book;
import com.nuc.entiy.Shop;
import com.nuc.entiy.User;
import com.nuc.util.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public class ShopDaoImpl implements ShopDao {

    BaseDao baseDao = new BaseDao();
    @Override
    public List<Shop> listShop(User user) {
        ResultSet rs = null;
        String sql = "select * from shop";
        rs = baseDao.executeQuery(sql);
        return null;
    }

    @Override
    public boolean addShop(Book book, User user) {
        return false;
    }

    @Override
    public boolean deleteShop(Shop shop, User user) {
        return false;
    }

    @Override
    public boolean updateShop(Shop shop, User user) {
        return false;
    }

    @Override
    public boolean sumMoney(User user, Date date) {
        return false;
    }
}
