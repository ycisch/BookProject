package com.nuc;

import com.nuc.dao.impl.ShopDaoImpl;
import com.nuc.entiy.Shop;
import com.nuc.entiy.User;

public class test {
    public static void main(String[] args) {
        ShopDaoImpl shopDao = new ShopDaoImpl();
        Shop shop = new Shop();
        User user = new User();
        shop.setShopId(1);
        shop.setBookId(2);
        shop.setUserId(1);
        shop.setNum(12);
        user.setId(1);
        //shopDao.deleteShop(shop,user);asdasdasdasd
        user.setMoney(123.0f);
        System.out.println(shopDao.sumMoney(user));
    }
}
