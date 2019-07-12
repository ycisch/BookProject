package com.nuc.dao.impl;

import com.nuc.dao.ShopDao;
import com.nuc.entiy.Book;
import com.nuc.entiy.Shop;
import com.nuc.entiy.User;
import com.nuc.util.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopDaoImpl implements ShopDao {

    BaseDao baseDao = new BaseDao();
    @Override
    public List<Shop> listShop(User user) {
        ResultSet rs = null;
        String sql = "select * from shop";
        rs = baseDao.executeQuery(sql);
        //ArrayList是基于数组的  线程不安全
        List<Shop> list = new ArrayList<>();
        try{
            while(rs.next()){
                Shop shop = new Shop();
                shop.setShopId(rs.getInt(1));
                shop.setBookId(rs.getInt(2));
                shop.setUserId(rs.getInt(3));
                shop.setNum(rs.getInt(4));
                shop.setUser(user);
                list.add(shop);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean addShop(Book book, User user) {
        ResultSet rs = null;
        String sql = "insert into shop(bookid,userid,num) values(?,?,?)";
        Object params[] = {book.getBookid(),user.getId(),1};
        int num1 = baseDao.executeUpdate(sql,params);
        if(num1 >= 1){
            baseDao.commit();
        }
        baseDao.runback();
        return false;
    }

    @Override
    /*
    删除购物车某条记录
     */
    public boolean deleteShop(Shop shop, User user) {
        int num = 1;
        String sql = "delete  from shop where shopid = ?";
        Object params[] ={shop.getShopId()};
        num = baseDao.executeUpdate(sql,params);
        int num1 = shop.getNum();
        if(num >= 1){
            String sql1 = "update book set booknum = booknum + ? where bookid = ?";
            Object params1[] = {shop.getNum(),shop.getBookId()};
            baseDao.executeUpdate(sql1,params1);
            baseDao.commit();
            return true;
        }
        baseDao.runback();
        return false;
    }

    @Override
    /*
    修改购物车
     */
    public boolean updateShop(Shop shop, User user) {

        String sql = "update shop set num = ? where shopid = ?";
        Object params[] = {shop.getNum(),shop.getShopId()};
        int num = baseDao.executeUpdate(sql,params);
        if(num >= 1){
            baseDao.commit();
            return true;
        }
        baseDao.runback();
        return false;
    }

    @Override
    public boolean sumMoney(User user) {
        int sum = 0;
        String sql = "select sum(num) as money from shop where userid = ?";
        Object params[] = {user.getId()};
        ResultSet rs = baseDao.executeQuery(sql,params);
        try {
            if(rs == null){
                return false;
            }
            while (rs.next()){
                sum = rs.getInt(1);
            }
            if(user.getMoney() < sum) return false;

            String sql1 = "update user set money = money - ? where id = ?";
            Object params1[] = {sum,user.getId()};
            int num1 = baseDao.executeUpdate(sql1,params1);
            //System.out.println(num1);
            if(num1 >= 1){
                sql1 = "delete from shop where userid = ?";
                Object params2[] = {user.getId()};
                if(baseDao.executeUpdate(sql1,params2) >= 1){
                    baseDao.commit();
                    return true;
                }
                baseDao.runback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
