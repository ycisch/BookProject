package com.nuc.service;

import com.nuc.entiy.Book;
import com.nuc.util.Page;

import java.util.List;

public interface BookService {

    /**
     * 图书管理
     */

    //查看某一图书
    public void selectBook(Book book);

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

    //按条件查询所有书籍总数
    public int sumBook(Book book);

    //查询所有书籍总数
    public int sumBook();
}
