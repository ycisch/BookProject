package com.nuc.service.impl;

import com.nuc.dao.ShopDao;
import com.nuc.dao.impl.ShopDaoImpl;
import com.nuc.entiy.Book;
import com.nuc.entiy.Shop;
import com.nuc.entiy.User;
import com.nuc.service.ShopService;

import java.util.Date;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    ShopDao shopDao = new ShopDaoImpl();

    @Override
    public List<Shop> listShop(User user) {
        return shopDao.listShop(user);
    }

    @Override
    public boolean addShop(Book book, User user) {
        return shopDao.addShop(book,user);
    }

    @Override
    public boolean deleteShop(Shop shop, User user) {
        return shopDao.deleteShop(shop,user);
    }

    @Override
    public boolean updateShop(Shop shop, User user) {
        return shopDao.updateShop(shop,user);
    }

    @Override
    public boolean sumMoney(User user,String ids[]) {
        return shopDao.sumMoney(user,ids);
    }
}
