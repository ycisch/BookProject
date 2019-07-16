package com.nuc.dao.impl;

import com.nuc.dao.BookDao;
import com.nuc.dao.OrderDao;
import com.nuc.dao.UserDao;
import com.nuc.entiy.Book;
import com.nuc.entiy.Order;
import com.nuc.entiy.Style;
import com.nuc.entiy.User;
import com.nuc.service.UserService;
import com.nuc.service.impl.UserServiceImpl;
import com.nuc.util.BaseDao;
import com.nuc.util.DatabaseUtil;
import com.nuc.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    BaseDao baseDao = new BaseDao();

    //修改订单
    @Override
    public boolean updateOrder(Order order, User uer) {
        boolean result = false;
        String sql = "update order set booknum=?,money=?";
        if (0 != baseDao.executeUpdate(sql, order.getBooknum(), order.getMoney())){
            baseDao.commit();
            result = true;
        }
        return result;
    }

    //删除订单
    @Override
    public boolean deleteOrder(Order order, User user) {
        boolean result = false;
        String sql = "delete from order where orderid=?";
        if (0!=baseDao.executeUpdate(sql,order.getOrderId())){
            baseDao.commit();
            result = true;
        }
        return result;
    }

    //查看个人订单
    @Override
    public List<Order> listOrder(User user, Page page) {
        String sql = "select * from order where userid = ?";
        Object params[] = {user.getId()};
        ResultSet rs = baseDao.executeQuery(sql,params);
        List<Order> list = new ArrayList<>();
        baseDao.commit();
        try{
            while (rs.next()){
                Order order = new Order();
                order.setBookId(rs.getInt(1));
                order.setBookId(rs.getInt(2));
                order.setBooknum(rs.getInt(3));
                order.setMoney(rs.getFloat(4));
                order.setUserId(rs.getInt(5));
                order.setCtdate(rs.getDate(6));
                list.add(order);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeAll(null,null,rs);
        }
        return null;
    }

    //查看所有订单
    @Override
    public List<Order> listOrder(Page page) {
        List<Order> orderList = new ArrayList<Order>();
        ResultSet resultSet = null;
        String sql = "select * from order";
        resultSet = baseDao.executeQuery(sql);
        Order order = null;
        try{
            while (resultSet.next()){
                order = new Order();
                order.setOrderId(resultSet.getInt("orderid"));
                order.setBookId(resultSet.getInt("bookid"));
                order.setBooknum(resultSet.getInt("booknum"));
                order.setMoney(resultSet.getFloat("money"));
                order.setUserId(resultSet.getInt("userid"));
                order.setCtdate(resultSet.getDate("ctdate"));
                order.setUser(this.setUser(order.getUserId()));
                order.setBook(this.setBook(order.getBookId()));
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeAll(null,null,resultSet);
        }

    return orderList;
    }

    public User setUser(int userid){
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setId(userid);
        user = userDao.getUser(user);
        return user;
    }

    public Book setBook(int bookid){
        BookDao bookDao = new BookDaoImpl();
        Book book = new Book();
        book.setBookid(bookid);
        return book;
    }

    //按个人查询所有订单总数
    @Override
    public int sumOrder(Order order) {
        return 0;
    }

    //查询订单总数
    @Override
    public int sumOrder() {
        int result = 0;
        ResultSet resultSet = null;
        String sql = "select count(*) from order";
        try{
            resultSet = baseDao.executeQuery(sql);
            while(resultSet.next()){
                result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeAll(null,null,resultSet);
        }
        return result;
    }

    //查看所有类别
    @Override
    public List<Style> listStyle() {
        String sql = "select * from style";
        List<Style> list = new ArrayList<>();

        ResultSet rs = baseDao.executeQuery(sql);
        baseDao.commit();
        //System.out.println(rs);
        try {
            while(rs.next()){
                Style style = new Style();
                style.setId(rs.getInt(1));
                style.setBookStyle(rs.getString(2));
                style.setBooksName(rs.getString(3));
                //System.out.println(style);
                list.add(style);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }


    //添加类别
    @Override
    public void addStyle(Style style) {

        String sql1 = "SELECT COUNT(DISTINCT bookstyle) from style";
        ResultSet rs = baseDao.executeQuery(sql1);
        int num = 0;
        try{
           while(rs.next()){
               num = rs.getInt(1);
           }
        }catch (SQLException e){
            e.printStackTrace();
        }
        String sql = "insert into style (bookstyle,booksname) values(?,?)";
        Object params[] = {num+1,style.getBooksName()};

        baseDao.executeUpdate(sql,params);

    }
}
