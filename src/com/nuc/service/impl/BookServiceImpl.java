package com.nuc.service.impl;

import com.nuc.dao.BookDao;
import com.nuc.dao.impl.BookDaoImpl;
import com.nuc.entiy.Book;
import com.nuc.service.BookService;
import com.nuc.util.BaseDao;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<Book> listBook() {
        List<Book> booklist = new ArrayList<Book>();
        BookDao bookDao = new BookDaoImpl();
        booklist = bookDao.listBook();
        return booklist;
    }

    @Override
    public boolean updateBook(Book book) {
        boolean result = false;
        BookDao bookDao = new BookDaoImpl();
        result = bookDao.updateBook(book);
        return false;
    }

    @Override
    public boolean deleteBook(Book book) {
        boolean result = false;
        BookDao bookDao = new BookDaoImpl();
        result = bookDao.deleteBook(book);
        return result;
    }

    @Override
    public boolean addBook(Book book) {
        boolean result = false;
        BookDao bookDao = new BookDaoImpl();
        result = bookDao.addBook(book);
        return result;
    }

    @Override
    public List<Book> listBookKey(Book book) {
        List<Book> bookList = new ArrayList<Book>();
        BookDao bookDao = new BookDaoImpl();
        bookList = bookDao.listBookKey(book);
        return bookList;
    }
}
