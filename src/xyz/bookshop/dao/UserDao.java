package xyz.bookshop.dao;

import xyz.bookshop.entity.User;

import java.sql.*;

import java.util.ResourceBundle;

/**
 * Created by moyu on 2017/6/12.
 */
public class UserDao extends BaseDao {

    public  User checkLogin(String username,String password){ //验证用户名密码
        try{
            ResultSet rs = this.select("select * from usrInfo where username=?", username,password);
            if(rs.next()){
                return new User(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3)
                );
            }
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean insertUser(String username,String password) {
        return this.modify("insert into users values(?,?,current_date())", username, password);
    }
    public static void main(String[] args){}


}
