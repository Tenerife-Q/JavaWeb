package com.blockchain.experiment.entity;

/**
 * @author Tenerife
 * Su san
 * @date 2025/12/30 16:35
 */

/**
 * 对应数据库表 book
 * 包含字段: bid, bookname, bookisbn, publisher, price, imgurl
 */
public class Book {
    private Integer bid;
    private String bookname;
    private String bookisbn;
    private String publisher;
    private Float price;
    private String imgurl;

    // 无参构造器
    public Book() {}

    // Getter 和 Setter 方法
    public Integer getBid() { return bid; }
    public void setBid(Integer bid) { this.bid = bid; }

    public String getBookname() { return bookname; }
    public void setBookname(String bookname) { this.bookname = bookname; }

    public String getBookisbn() { return bookisbn; }
    public void setBookisbn(String bookisbn) { this.bookisbn = bookisbn; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public Float getPrice() { return price; }
    public void setPrice(Float price) { this.price = price; }

    public String getImgurl() { return imgurl; }
    public void setImgurl(String imgurl) { this.imgurl = imgurl; }
}