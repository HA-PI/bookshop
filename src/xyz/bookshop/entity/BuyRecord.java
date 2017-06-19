package xyz.bookshop.entity;

import java.io.InputStream;
import java.sql.Date;

/**
 * Created by PC on 2017/6/18.
 */
public class BuyRecord {
    private String username;
    private int buynumber;
    private Date buytime;
    private int bookid;
    private String bookname;
    private String author;
    private float price;
    private String press;
    private InputStream img;
    private String imgtype;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBuynumber() {
        return buynumber;
    }

    public void setBuynumber(int buynumber) {
        this.buynumber = buynumber;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
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
    public BuyRecord( String username,int buynumber,Date buytime,int bookid,String bookname, String author, float price,
                 String press, InputStream img,String imgtype) {
        this.username = username;
        this.buynumber = buynumber;
        this.buytime = buytime;
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
        this.price = price;
        this.press = press;
        this.img = img;
        this.imgtype = imgtype;
    }

    @Override
    public String toString() {
        return "BuyRecord{" +
                "username='" + username + '\'' +
                ", buynumber=" + buynumber +
                ", buytime=" + buytime +
                ", bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                ", img=" + img +
                ", imgtype='" + imgtype + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
