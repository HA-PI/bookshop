package xyz.bookshop.dao;

import xyz.bookshop.entity.User;

import java.sql.*;

import java.util.ResourceBundle;

/**
 * Created by moyu on 2017/6/12.
 */
public class UserDao extends BaseDao {

    public boolean checkLogin(User user) { //验证用户名密码
        try {
            ResultSet rs = this.select("select * from usrInfo where username=? and password=PASSWORD(?)", user.getUsername(), user.getPassword());
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insert(User user) {
        return this.modify("insert into usrInfo values(?,PASSWORD(?),current_date())", user.getUsername(), user.getPassword());
    }

    public static void main(String[] args) {
    }


}
