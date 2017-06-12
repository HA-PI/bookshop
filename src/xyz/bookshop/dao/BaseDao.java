package xyz.bookshop.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by moyu on 2017/6/12.
 */
public abstract class BaseDao {
    /*private static String url;
    private static String username;
    private static String password;
    private static String driver;*/

    static DataSource ds;

    static {
        Context c;
        try {
            c = new InitialContext();
            ds = (DataSource) c.lookup("java:comp/env/jdbc/mysql");
        } catch (NamingException e) {
            System.err.println("数据库连接创建戳无");
            e.printStackTrace();
        }
    }


    /*static {
        ResourceBundle config = ResourceBundle.getBundle("xyz.bookshop.config.db");
        url = config.getString("jdbc.url");
        username = config.getString("jdbc.username");
        password = config.getString("jdbc.password");
        driver = config.getString("jdbc.driver");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    private Connection conn;

    public Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = ds.getConnection();
            return conn;
        } else {
            return conn;
        }
    }
    /*public Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, username, password);
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    public ResultSet select(String sql, Object... arguments) {
        try {
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < arguments.length; i++) {
                ps.setObject(i + 1, arguments[i]);
            }
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean modify(String sql, Object... args) {
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        close();
    }


    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
