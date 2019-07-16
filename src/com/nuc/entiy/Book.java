package com.nuc.entiy;

public class Book {
    private int bookid;
    private String bookName;
    private String bookAuthor;
    private String bookInfo;
    private int bookNum;
    private String bookStyle;
    private float bookMoney;
    private String bookimg;
    private String bookCategory;

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookInfo='" + bookInfo + '\'' +
                ", bookNum=" + bookNum +
                ", bookStyle='" + bookStyle + '\'' +
                ", bookMoney=" + bookMoney +
                ", bookimg='" + bookimg + '\'' +
                ", bookCategory='" + bookCategory + '\'' +
                '}';
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getBookimg() {
        return bookimg;
    }

    public void setBookimg(String bookimg) {
        this.bookimg = bookimg;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookStyle() {
        return bookStyle;
    }

    public void setBookStyle(String bookStyle) {
        this.bookStyle = bookStyle;
    }

    public float getBookMoney() {
        return bookMoney;
    }

    public void setBookMoney(float bookMoney) {
        this.bookMoney = bookMoney;
    }
}
