package com.nuc.entiy;

import java.util.Date;

/**
 *
 */
public class Order {
    private int orderId;
    private int bookId;
    private int booknum;
    private float money;
    private int userId;
    private Date ctdate;

    private User user;
    private Book book;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBooknum() {
        return booknum;
    }

    public void setBooknum(int booknum) {
        this.booknum = booknum;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCtdate() {
        return ctdate;
    }

    public void setCtdate(Date ctdate) {
        this.ctdate = ctdate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", bookId=" + bookId +
                ", booknum=" + booknum +
                ", money=" + money +
                ", userId=" + userId +
                ", ctdate=" + ctdate +
                ", user=" + user +
                ", book=" + book +
                '}';
    }
}
