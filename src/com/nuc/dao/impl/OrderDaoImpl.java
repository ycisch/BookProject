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
import com.sun.org.apache.xpath.internal.operations.Or;

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

        double oldMoney = 0;                //原订单的金额
        double money = 0;
        String oldOrderMoney = "select money from bookshop.order where orderid=?";       //查原订单的金额
        ResultSet resultSet = null;
        String oldUserMoney = "select money from user where id=?";          //查用户原来的余额
        String sql = "update bookshop.order set booknum=?,money=? where orderid=?";                      //修改订单
        String updateMoney = "update user set money=? where id=?";              //修改用户余额
        try {
            resultSet = baseDao.executeQuery(oldOrderMoney,order.getOrderId());//查原订单的金额
            while (resultSet.next()){
                oldMoney = resultSet.getFloat("money");
            }
            money = oldMoney-order.getMoney();              //得到订单金额差值
            resultSet = baseDao.executeQuery(oldUserMoney,order.getUserId());//查用户原来的余额
            while (resultSet.next()){
                oldMoney = resultSet.getFloat("money");
            }
            money = oldMoney+money;                         //得到用户需要修改为的金额
            if (0 != baseDao.executeUpdate(updateMoney,money,order.getUserId())&&0 != baseDao.executeUpdate(sql, order.getBooknum(), order.getMoney(),order.getOrderId())){
                baseDao.commit();
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeAll(null,null,resultSet);
        }
        return result;
    }

    //删除订单
    @Override
    public boolean deleteOrder(Order order, User user) {
        boolean result = false;
        ResultSet resultSet = null;
        double money = 0;                //需要加回用户的金额
        double oldMoney = 0;               //用户余额
        String oldOrderMoney = "select money from bookshop.order where orderid=?";       //查原订单的金额
        String updateMoney = "update user set money=? where id=?";              //修改用户余额
        String sql = "delete from bookshop.order where orderid=?";                       //删除订单
        String oldUserMoney = "select money from user where id=?";          //查用户原来的余额
        try {
            resultSet = baseDao.executeQuery(oldOrderMoney,order.getOrderId()); //查原订单的金额
            while (resultSet.next()){
                money = resultSet.getFloat("money");
            }
            resultSet = baseDao.executeQuery(oldUserMoney,order.getUserId());//查用户原来的余额
            while (resultSet.next()){
                oldMoney = resultSet.getFloat("money");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        money = money+oldMoney;
        if (0!=baseDao.executeUpdate(updateMoney,money,order.getUserId())&&0!=baseDao.executeUpdate(sql,order.getOrderId())){
            baseDao.commit();
            result = true;
        }
        return result;
    }

    @Override
    public Order selectOrder(Order order1) {

        Order order = new Order();

        String sql = "select * from bookshop.order where orderid=?";
        ResultSet resultSet = baseDao.executeQuery(sql,order1.getOrderId());
        try {
            BookDao bookDao = new BookDaoImpl();
            UserDao userDao = new UserDaoImpl();
            while (resultSet.next()){

                order.setOrderId(resultSet.getInt("orderid"));
                order.setBookId(resultSet.getInt("bookid"));
                order.setBooknum(resultSet.getInt("booknum"));
                Book book = new Book();
                book.setBookid(order.getBookId());
                bookDao.selectBook(book);
                System.out.println(book+"@@@@!!!!!!!");
                order.setBook(book);
                order.setMoney(resultSet.getFloat("money"));
                order.setUserId(resultSet.getInt("userid"));
                User user = new User();
                user.setId(order.getUserId());
                userDao.getUser(user);
                order.setUser(user);
                order.setCtdate(resultSet.getDate("ctdate"));
//                order.setUser(this.setUser(order.getUserId()));
//                order.setBook(this.setBook(order.getBookId()));
                System.out.println(order);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return order;
    }

    //查看个人订单
    @Override
    public List<Order> listOrder(User user, Page page) {
        String sql = "select * from bookshop.order where userid = ?";
        Object params[] = {user.getId()};
        ResultSet rs = baseDao.executeQuery(sql,params);
        List<Order> list = new ArrayList<>();
        baseDao.commit();
        try{
            BookDao bookDao = new BookDaoImpl();
            while (rs.next()){
                Order order = new Order();
                order.setOrderId(rs.getInt(1));
                order.setBookId(rs.getInt(2));
                order.setBooknum(rs.getInt(3));
                Book book = new Book();
                book.setBookid(order.getBookId());
                bookDao.selectBook(book);
                order.setBook(book);
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
        return list;
    }

    //查看所有订单
    @Override
    public List<Order> listOrder() {
        List<Order> orderList = new ArrayList<Order>();
        ResultSet resultSet = null;
        String sql = "select * from bookshop.order";
        resultSet = baseDao.executeQuery(sql);
        Order order = null;
        try{
            BookDao bookDao = new BookDaoImpl();
            UserDao userDao = new UserDaoImpl();
            while (resultSet.next()){
                order = new Order();
                order.setOrderId(resultSet.getInt("orderid"));
                order.setBookId(resultSet.getInt("bookid"));
                order.setBooknum(resultSet.getInt("booknum"));
                Book book = new Book();
                book.setBookid(order.getBookId());
                bookDao.selectBook(book);
                System.out.println(book+"@@@@");
                order.setBook(book);
                order.setMoney(resultSet.getFloat("money"));
                order.setUserId(resultSet.getInt("userid"));
                User user = new User();
                user.setId(order.getUserId());
                userDao.getUser(user);
                order.setUser(user);
                order.setCtdate(resultSet.getDate("ctdate"));
//                order.setUser(this.setUser(order.getUserId()));
//                order.setBook(this.setBook(order.getBookId()));
                orderList.add(order);
                System.out.println(order);
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
        int result = 0;
        ResultSet resultSet = null;
        String sql = "select count(*) from bookshop.order where userid=?";
        try {
            resultSet = baseDao.executeQuery(sql,order.getUserId());
            while (resultSet.next()){
                result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeAll(null,null,resultSet);
        }
        return 0;
    }

    //查询订单总数
    @Override
    public int sumOrder() {
        int result = 0;
        ResultSet resultSet = null;
        String sql = "select count(*) from bookshop.order";
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
                style.setBooksName(rs.getString(4));
                style.setBookCategory(rs.getString(3));
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
