package com.exp3_bookmanagement.model;

/**
 * @author Tenerife
 * Su san
 * @date 2025/12/23 15:03
 */

public class Book {
    private String bookname;
    private String bookisbn;
    private String publisher;
    private Double price;
    private String imgurl;

    public Book() {}

    public Book(String bookname, String bookisbn, String publisher, Double price, String imgurl) {
        this.bookname = bookname;
        this.bookisbn = bookisbn;
        this.publisher = publisher;
        this.price = price;
        this.imgurl = imgurl;
    }

    public String getBookname() { return bookname; }
    public void setBookname(String bookname) { this.bookname = bookname; }
    public String getBookisbn() { return bookisbn; }
    public void setBookisbn(String bookisbn) { this.bookisbn = bookisbn; }
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getImgurl() { return imgurl; }
    public void setImgurl(String imgurl) { this.imgurl = imgurl; }
}