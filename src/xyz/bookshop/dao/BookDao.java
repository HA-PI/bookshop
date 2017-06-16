package xyz.bookshop.dao;
import xyz.bookshop.entity.*;
import java.sql.*;

/**
 * Created by PC on 2017/6/16.
 */
public class BookDao extends BaseDao{
    public boolean exists(Book book){
        try {
            ResultSet rs = this.select("select * from bookInfo where bookname=? ", book.getName());
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }
    public User find(String username) {
        try {
            ResultSet rs = this.select("select * from usrInfo where username=?", username);
            if (rs.next()) {
                return new User(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Book find(Book book) {
        try {
            ResultSet rs = this.select("select * from bookInfo where bookname=?", book.getName());
            if (rs.next()) {
                return new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getBlob(7)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(Book book) {
        return this.modify("insert into bookInfo values(null,?,?,?,?,?)"
                ,book.getName(),book.getAuthor(),book.getPrice(),
                book.getNumber(),book.getPress(),book.getImg());
    }







}
