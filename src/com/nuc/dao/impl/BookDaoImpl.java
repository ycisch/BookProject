package com.nuc.dao.impl;

import com.nuc.dao.BookDao;
import com.nuc.entiy.Book;
import com.nuc.util.BaseDao;
import com.nuc.util.DatabaseUtil;
import com.nuc.util.Page;

import javax.sound.midi.Soundbank;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    @Override
    public void selectBook(Book book) {
        BaseDao baseDao = new BaseDao();
        String sql  = "select * from book where bookid = ?";
        ResultSet rs = baseDao.executeQuery(sql,book.getBookid());
        try{
            while(rs.next()){
                book.setBookName(rs.getString(2));
                book.setBookAuthor(rs.getString(3));
                book.setBookInfo(rs.getString(4));
                book.setBookMoney(rs.getFloat(5));
                book.setBookNum(rs.getInt(6));
                book.setBookStyle(rs.getString(7));
                book.setBookimg(rs.getString(8));
//                System.out.println(book+"@####");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //查看所有图书
    @Override
    public List<Book> listBook(Page page) {
        List<Book> bookList = new ArrayList<Book>();
        ResultSet resultSet = null;
        BaseDao baseDao = new BaseDao();
        String sql = "select * from book limit ?,?";
        resultSet = baseDao.executeQuery(sql,page.getCurrPageNo()*page.getPageSize(),page.getPageSize());
        Book book = null;
        try{
            while (resultSet.next()){
                book = new Book();
                book.setBookid(resultSet.getInt("bookid"));
                book.setBookName(resultSet.getString("bookname"));
                book.setBookAuthor(resultSet.getString("bookauthor"));
                book.setBookInfo(resultSet.getString("bookinfo"));
                book.setBookMoney(resultSet.getFloat("bookmoney"));
                book.setBookNum(resultSet.getInt("booknum"));
                book.setBookStyle(resultSet.getString("bookstyle"));
                String name = resultSet.getString("bookimg");
                name = name.substring(2,name.length());
                book.setBookimg(name);
                bookList.add(book);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeAll(null,null,resultSet);
        }
        return bookList;
    }

    //修改图书
    @Override
    public boolean updateBook(Book book) {
        boolean result = false;
        String sql = "update book " +
                "set bookname=?,bookauthor=?,bookinfo=?,bookmoney=?,booknum=?,bookstyle=?,bookimg=? " +
                "where bookid=?";
        BaseDao baseDao =new BaseDao();
        if (0!=baseDao.executeUpdate(sql,book.getBookName(),book.getBookAuthor(),book.getBookInfo(),book.getBookMoney(),book.getBookNum(),book.getBookStyle(),book.getBookimg(),book.getBookid())){
            baseDao.commit();
            result = true;
        }
        return result;
    }

    //删除图书
    @Override
    public boolean deleteBook(Book book) {
        boolean result = false;
        String sql = "delete from book where bookid=?";
        BaseDao baseDao = new BaseDao();
        if (0!=baseDao.executeUpdate(sql,book.getBookid())){
            baseDao.commit();
            result = true;
        }
        return result;
    }

    //添加图书
    @Override
    public boolean addBook(Book book) {
        boolean result = false;
        String sql = "insert into book (bookid,bookname,bookauthor,bookinfo,bookmoney,booknum,bookstyle,bookimg) values(?,?,?,?,?,?,?,?)";
        BaseDao baseDao = new BaseDao();
        if (0!=baseDao.executeUpdate(sql,book.getBookid(),book.getBookName(),book.getBookAuthor(),book.getBookInfo(),book.getBookMoney(),book.getBookNum(),book.getBookStyle(),book.getBookimg())){
            baseDao.commit();
            result = true;
        }
        return result;
    }

    //按条件查询图书
    @Override
    public List<Book> listBookKey(Book book, Page page) {
        BaseDao baseDao = new BaseDao();
        List<Book> bookList = new ArrayList<Book>();
        ResultSet resultSet = null;

        /*System.out.println(page.toString());*/
        System.out.println("dao层book，page："+book+"******"+page);
        System.out.println(book.getBookStyle());

        //条件判断
        if(book.getBookStyle().equals("name")){
            String sql = "select * from book where bookname=? limit ?,?";
            resultSet = baseDao.executeQuery(sql,book.getBookName(),page.getCurrPageNo()*page.getPageSize(),page.getPageSize());
        }else if(book.getBookStyle().equals("id")){
            String sql = "select * from book where bookid=? limit ?,?";
            resultSet = baseDao.executeQuery(sql,book.getBookid(),page.getCurrPageNo()*page.getPageSize(),page.getPageSize());
        }else if(book.getBookStyle().equals("style")){
            String sql = "select * from book where bookstyle=? limit ?,?";
            System.out.println(page.getCurrPageNo()+"  style "+page.getPageSize()+"######"+book.getBookName());
            resultSet = baseDao.executeQuery(sql,book.getBookName(),page.getCurrPageNo()*page.getPageSize(),page.getPageSize());
        }
        Book keybook = null;
        try{
            while (resultSet.next()){
                keybook = new Book();
                keybook.setBookid(resultSet.getInt("bookid"));
                keybook.setBookName(resultSet.getString("bookname"));
                keybook.setBookAuthor(resultSet.getString("bookauthor"));
                keybook.setBookInfo(resultSet.getString("bookinfo"));
                keybook.setBookMoney(resultSet.getFloat("bookmoney"));
                keybook.setBookNum(resultSet.getInt("booknum"));
                keybook.setBookStyle(resultSet.getString("bookstyle"));
                String name = resultSet.getString("bookimg");
                name = name.substring(2,name.length());
                keybook.setBookimg(name);
                bookList.add(keybook);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeAll(null,null,resultSet);
        }
        return bookList;
    }

    //获取书籍总和
    @Override
    public int sumBook(Book book) {
        String sql = "";
        Object params[]=null;
        BaseDao baseDao = new BaseDao();
        if("name".equals(book.getBookStyle())){
            sql = "select COUNT(*) FROM book where bookname = ?";
        }else if("style".equals(book.getBookStyle())){
            sql = "select COUNT(*) FROM book where bookstyle = ?";
        }else if("id".equals(book.getBookStyle())){
            sql = "select COUNT(*) FROM book where bookid = ?";
        }
        params = new Object[]{book.getBookName()};
        ResultSet rs = baseDao.executeQuery(sql,params);
        int ans = 0;
        try {

            while (rs.next()){
                ans = rs.getInt(1);
            }
            baseDao.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeAll(null,null,rs);
        }
        return ans;
    }

    @Override
    public int sumBook() {
        int result = 0;
        ResultSet resultSet = null;
        String sql = "select count(*) from book";
        BaseDao baseDao = new BaseDao();
        try {
            resultSet = baseDao.executeQuery(sql);
            while (resultSet.next()){
                result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeAll(null,null,resultSet);
        }
        return result;
    }
}
