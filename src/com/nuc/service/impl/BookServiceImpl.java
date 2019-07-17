package com.nuc.service.impl;

import com.nuc.dao.BookDao;
import com.nuc.dao.impl.BookDaoImpl;
import com.nuc.entiy.Book;
import com.nuc.entiy.Style;
import com.nuc.service.BookService;
import com.nuc.util.BaseDao;
import com.nuc.util.DatabaseUtil;
import com.nuc.util.Date;
import com.nuc.util.Page;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    @Override
    public void selectBook(Book book) {
        BookDao bookDao = new BookDaoImpl();
        bookDao.selectBook(book);
        String img = book.getBookimg().substring(2,book.getBookimg().length());
        book.setBookimg(img);
//        System.out.println(book+"@####%%%%%");
    }

    //查看所有图书
    @Override
    public List<Book> listBook(Page page) {
        List<Book> booklist = new ArrayList<Book>();
        BookDao bookDao = new BookDaoImpl();
        booklist = bookDao.listBook(page);




        return booklist;
    }

    //修改图书
    @Override
    public boolean updateBook(Book book) {
        boolean result = false;
        BookDao bookDao = new BookDaoImpl();
        result = bookDao.updateBook(book);
        return false;
    }

    //删除图书
    @Override
    public boolean deleteBook(Book book) {
        boolean result = false;
        BookDao bookDao = new BookDaoImpl();
        result = bookDao.deleteBook(book);
        return result;
    }

    //添加图书
    @Override
    public boolean addBook(Book book) {
        boolean result = false;
        BookDao bookDao = new BookDaoImpl();
        result = bookDao.addBook(book);
        return result;
    }

    //按条件查询图书
    @Override
    public List<Book> listBookKey(Book book, Page page) {
        List<Book> bookList = new ArrayList<Book>();
        BookDao bookDao = new BookDaoImpl();
        bookList = bookDao.listBookKey(book,page);

        //获取当前的字符串
        for(Book book1:bookList){
            //遍历Date中的数据
            for(Style style1: Date.MAP){
                if(style1.getBookStyle().equals(book1.getBookStyle())){
                    book1.setBookStyle_value(style1.getBooksName());
                    break;
                }
            }

            List<Style> list = Date.MAP_TWO.get(book1.getBookStyle());
            for(Style style1: list){
                if(style1.getBookStyle().equals(book1.getBookCategory())){
                    book1.setBookCategory_value(style1.getBooksName());
                }
            }
            System.out.println(book1);
        }

        return bookList;
    }

    @Override
    public int sumBook(Book book) {
        BookDao bookDao = new BookDaoImpl();
        return bookDao.sumBook(book);
    }

    @Override
    public int sumBook() {
        int result = 0;
        BookDao bookDao = new BookDaoImpl();
        result = bookDao.sumBook();
        return result;
    }
}
