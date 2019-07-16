package com.nuc.entiy;

public class Style {
    private int id;
    private String bookStyle;
    private String booksName;
    private String bookCategory;


    @Override
    public String toString() {
        return "Style{" +
                "id=" + id +
                ", bookStyle='" + bookStyle + '\'' +
                ", booksName='" + booksName + '\'' +
                ", bookCategory='" + bookCategory + '\'' +
                '}';
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookStyle() {
        return bookStyle;
    }

    public void setBookStyle(String bookStyle) {
        this.bookStyle = bookStyle;
    }

    public String getBooksName() {
        return booksName;
    }

    public void setBooksName(String booksName) {
        this.booksName = booksName;
    }

}
