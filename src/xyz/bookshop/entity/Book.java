package xyz.bookshop.entity;

import java.io.InputStream;
import java.sql.Date;

/**
 * Created by PC on 2017/6/16.
 */
public class Book {
    private int id;
    private String name;
    private String author;
    private float price;
    private int number;
    private String press;
    private InputStream img;
    private String imgtype;
    private String belong;
    private Date intime;

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public InputStream getImg() {
        return img;
    }

    public void setImg(InputStream img) {
        this.img = img;
    }

    public String getImgtype() {
        return imgtype;
    }

    public void setImgtype(String imgtype) {
        this.imgtype = imgtype;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", press='" + press + '\'' +
                ", img=" + img +
                ", imgtype='" + imgtype + '\'' +
                ", belong='" + belong + '\'' +
                ", intime=" + intime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public Book(int id, String name, String author, float price, int number,
                String press, InputStream img,String imgtype,String belong,Date intime ) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.number = number;
        this.press = press;
        this.img = img;
        this.imgtype=imgtype;
        this.belong=belong;
        this.intime=intime;
    }
    public Book( String name, String author, float price, int number,
                 String press, InputStream img,String imgtype,String belong) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.number = number;
        this.press = press;
        this.img = img;
        this.imgtype=imgtype;
        this.belong=belong;

    }
}
