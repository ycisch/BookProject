package com.nuc.entiy;

/**
 *  shopId  订单号
 *  bookId  书号
 *  userId  用户Id
 *  num     购买数量
 *
 *  user    用户信息
 *  book    书籍信息
 *
 *  1->1
 */
public class Shop {
    private int shopId;
    private int bookId;
    private int userId;
    private int num;

    private int numid;


    private User user;
    private Book book;

    public int getNumid() {
        return numid;
    }

    public void setNumid(int numid) {
        this.numid = numid;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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
        return "Shop{" +
                "shopId=" + shopId +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", num=" + num +
                ", user=" + user +
                ", book=" + book +
                '}';
    }
}
