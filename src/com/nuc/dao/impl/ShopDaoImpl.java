package com.nuc.dao.impl;

import com.nuc.dao.ShopDao;
import com.nuc.entiy.Book;
import com.nuc.entiy.Shop;
import com.nuc.entiy.User;

import java.util.Date;
import java.util.List;

public class ShopDaoImpl implements ShopDao {
    @Override
    public List<Shop> listShop() {
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
