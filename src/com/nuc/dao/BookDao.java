package com.nuc.dao;

import com.nuc.entiy.Book;

import java.util.List;

public interface BookDao {
    /**
     * 图书管理
     */

    //查看所有图书
    public List<Book> listBook();

    //修改图书
    public boolean updateBook(Book book);

    //删除图书
    public boolean deleteBook(Book book);

    //添加图书
    public boolean addBook(Book book);

    //按条件查询图书
    public List<Book> listBookKey(Book book);
}
