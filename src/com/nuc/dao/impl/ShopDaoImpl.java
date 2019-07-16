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
import java.util.Arrays;
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
        System.out.println(book+"@@@"+user);
        ResultSet rs = null;
        int num = 1,id = 0;
        String sql1 = "select * from shop where bookid = ? and userid=?";
        String sql="";
        Object params[] = null;
        System.out.println(book.getBookid()+"   "+user.getId());
        rs = baseDao.executeQuery(sql1,book.getBookid(),user.getId());
        baseDao.commit();
        //System.out.println(rs);

        System.out.println(rs+"@@@");

        try {
            while(rs.next()){
                num = rs.getInt(4);
                id = rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        System.out.println(id);
        if(id !=0){
            //System.out.println(num+"  "+id);
            rs = null;
            if(book.getBookNum() == 1) sql = "update shop set num=num+1 where shopid=?";
            else sql = "update shop set num=num-1 where shopid=?";
            params = new Object[]{id};
        }
        else{
            sql = "insert into shop(bookid,userid,num) values(?,?,?)";
            params = new Object[]{book.getBookid(), user.getId(), num};
        }
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
    public boolean sumMoney(User user,String ids[]) {
        float sum = 0,ans = 0;
        int bookid = 0,userid = 0,num=0;
        String sql = "";
        Object params[]=null;
        for(int i = 0; i < ids.length; i++){
            sql = "select CAST(sum(num*b.bookmoney)  AS decimal(18,2))as money,s.num,s.bookid,s.userid from shop s,book b where userid = ? and b.bookid = s.bookid and s.bookid=?";
            params = new Object[]{user.getId(),ids[i]};
            ResultSet rs = baseDao.executeQuery(sql,params);
            baseDao.commit();
            if(rs == null){
                return false;
            }
            try {
                while (rs.next()){
                    sum += rs.getFloat(1);
                    ans = rs.getFloat(1);
                    num = rs.getInt(2);
                    bookid = rs.getInt(3);
                    userid = rs.getInt(4);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

            sql = "insert into bookshop.order(bookid,booknum,money,userid,ctdate) values(?,?,?,?,?)";
            params = new Object[]{bookid, num, ans, userid, new Date()};

            baseDao.executeUpdate(sql,params);
            baseDao.commit();

        }
        if(user.getMoney() < sum) return false;
        String sql1 = "update user set money = money - ? where id = ?";
        Object params1[] = {sum,user.getId()};
        int num1 = baseDao.executeUpdate(sql1,params1);
        if(num1 >= 1){
            for (int i = 0; i < ids.length; i++){
                sql1 = "delete from shop where userid = ? and bookid = ?";
                Object params2[] = {user.getId(),ids[i]};
                if(baseDao.executeUpdate(sql1,params2) >= 1){
                    baseDao.commit();
                }
                else{
                    baseDao.runback();
                    return true;
                }
            }
            user.setMoney(user.getMoney()-sum);
        }
        return false;
    }
}
