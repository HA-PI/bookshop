package xyz.bookshop.entity;

import java.sql.*;

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
    private Blob img;

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

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
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

    public Book(int id, String name, String author, float price, int number, String press, Blob img) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.number = number;
        this.press = press;
        this.img = img;
    }


}
