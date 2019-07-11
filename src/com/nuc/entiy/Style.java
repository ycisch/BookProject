package com.nuc.entiy;

public class Style {
    private int id;
    private String bookStyle;
    private String booksName;

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

    @Override
    public String toString() {
        return "Style{" +
                "id=" + id +
                ", bookStyle='" + bookStyle + '\'' +
                ", booksName='" + booksName + '\'' +
                '}';
    }
}
