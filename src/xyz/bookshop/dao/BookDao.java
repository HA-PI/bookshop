package xyz.bookshop.dao;

import xyz.bookshop.entity.*;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2017/6/16.
 */
public class BookDao extends BaseDao {
    public boolean exists(String bookid) {
        try {
            ResultSet rs = this.select("select * from bookInfo where bookid=? ", bookid);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Book find(String bookid) {
        try {
            ResultSet rs = this.select("select * from bookInfo where bookid=?", bookid);
            if (rs.next()) {
                return new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getBinaryStream(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDate(10)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(Book book) {
        return this.modify("insert into bookInfo values(null,?,?,?,?,?,?,?,?,now())",
                book.getName(), book.getAuthor(), book.getPrice(),
                book.getNumber(), book.getPress(), book.getImg(), book.getImgtype(), book.getBelong());
    }

    public int count(int page,int pageSize,String notBelong){
        int rowCounts;
        List<Book> list=list(page,pageSize,notBelong);
        if(list==null)
        {
            rowCounts=1;
        }
        else
        {
            rowCounts=list.size();
        }
        int pageCounts=(rowCounts+pageSize-1)/pageSize;
        return pageCounts;
    }

    public int count(int page,int pageSize){
        int rowCounts;
        List<Book> list=list(page,pageSize);
        if(list==null)
        {
            rowCounts=1;
        }
        else
        {
            rowCounts=list.size();
        }
        int pageCounts=(rowCounts+pageSize-1)/pageSize;
        return pageCounts;
    }

    private List<Book> list(String sql, Object ...args) {
        try {
            List<Book> list = new ArrayList<Book>();
            ResultSet rs = this.select(sql, args);
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getBinaryStream(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDate(10)
                );
                list.add(book);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> list(int page, int pageSize, String notBelong) {
        int pageCounts=count(page,pageSize,notBelong);
        if(page<1) page=1;
        if(page>pageCounts) page=pageCounts;
        return list("select * from bookInfo where belong!=? order by intime desc limit ?,? ", notBelong, (page-1)*pageSize, pageSize);
    }

    public List<Book> list(int page, int pageSize) {
        int pageCounts=count(page,pageSize);
        if(page<1) page=1;
        if(page>pageCounts) page=pageCounts;
        return list("select * from bookInfo order by intime desc limit ?,? ", (page-1)*pageSize, pageSize);
    }

    public List<Book> mylist(int page, int pageSize,String belong) {
        int pageCounts=count(page,pageSize,belong);
        if(page<1) page=1;
        if(page>pageCounts) page=pageCounts;
        return list("select * from bookInfo where belong = ? order by intime desc limit ?,?", belong, (page-1)*pageSize, pageSize);
    }

}
