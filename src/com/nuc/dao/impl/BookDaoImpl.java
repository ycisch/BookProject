package com.nuc.dao.impl;

import com.nuc.dao.BookDao;
import com.nuc.entiy.Book;
import com.nuc.util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    //查看所有图书
    @Override
    public List<Book> listBook() {
        List<Book> bookList = new ArrayList<Book>();
        ResultSet resultSet = null;
        String sql = "select * from book";
        BaseDao baseDao = new BaseDao();
        resultSet = baseDao.executeQuery(sql);
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
                book.setBookimg(resultSet.getString("bookimg"));
                bookList.add(book);
            }
        }catch (SQLException e){
            e.printStackTrace();
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
    public List<Book> listBookKey(Book book) {
        List<Book> bookList = new ArrayList<Book>();
        ResultSet resultSet = null;
        String sql = "select * from book where bookname=?";
        BaseDao baseDao = new BaseDao();
        resultSet = baseDao.executeQuery(sql,book.getBookName());
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
                keybook.setBookimg(resultSet.getString("bookimg"));
                bookList.add(keybook);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return bookList;
    }
}
