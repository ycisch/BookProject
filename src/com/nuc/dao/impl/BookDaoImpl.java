package com.nuc.dao.impl;

import com.nuc.dao.BookDao;
import com.nuc.entiy.Book;
import com.nuc.util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
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
                bookList.add(book);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public boolean updateBook(Book book) {
        boolean result = false;
        String sql = "update book " +
                "set(bookname,bookauthor,bookinfo,bookmoney,booknum,bookstyle,bookimg)" +
                " = (select ?,?,?,?,?,?,?)" +
                "where bookid=?";
        BaseDao baseDao =new BaseDao();
        if (0!=baseDao.executeUpdate(sql,book.getBookName(),book.getBookAuthor(),book.getBookInfo(),book.getBookMoney(),book.getBookNum(),book.getBookStyle(),book.getBookimg(),book.getBookid())){
            baseDao.commit();
            result = true;
        }
        System.out.println(result);
        return result;
    }

    @Override
    public boolean deleteBook(Book book) {
        return false;
    }

    @Override
    public boolean addBook(Book book) {
        return false;
    }

    @Override
    public List<Book> listBookKey(Book book) {
        return null;
    }
}
