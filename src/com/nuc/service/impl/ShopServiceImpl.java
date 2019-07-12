package com.nuc.service.impl;

import com.nuc.entiy.Book;
import com.nuc.entiy.Shop;
import com.nuc.entiy.User;
import com.nuc.service.ShopService;

import java.util.Date;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    @Override
    public List<Shop> listShop(User user) {
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
