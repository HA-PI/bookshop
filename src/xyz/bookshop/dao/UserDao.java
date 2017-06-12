package xyz.bookshop.dao;

import xyz.bookshop.entity.User;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by moyu on 2017/6/12.
 */
public class UserDao extends BaseDao {

    public User find(String username) {
        ResultSet rs = this.select("select * from users where username=?", username);
        try {
            if (rs.next()) {
                return new User(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getDate(3)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add (User user) {
        return this.modify("insert into users values(?,?,current_date())", user.getUsername(), user.getPassword());
    }

    public boolean exists (User user) {
        return this.modify("insert into users values(?,?,current_date())", user.getUsername(), user.getPassword());
    }

}
