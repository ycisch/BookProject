package com.nuc.servlet;

import com.nuc.entiy.Book;
import com.nuc.entiy.Style;
import com.nuc.entiy.User;
import com.nuc.service.OrderService;
import com.nuc.service.ShopService;
import com.nuc.service.impl.OrderServiceImpl;
import com.nuc.service.impl.ShopServiceImpl;
import com.nuc.util.Date;

import java.util.Map;

public class test {

    public static void main(String[] args) {
        ShopService shopService = new ShopServiceImpl();

        User user = new User();
        user.setId(1);
        user.setMoney(8000);
        Book book = new Book();
        book.setBookid(1);
        String ids[] = {"5","6"};
        shopService.sumMoney(user,ids);

        Style style = new Style();
        style.setBooksName("社交");

    }
}
