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

    public List<Book> list(int page,int pageSize) {
        try {
            List<Book> list =new ArrayList<Book>();
            ResultSet rs = this.select("select * from bookInfo ordered by desc intime limit ?,? ",page,pageSize);
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




}
