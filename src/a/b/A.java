package a.b;

import net.sf.json.JSONObject;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * Created by moyu on 2017/6/8.
 */
public class A {
    public String a = "sss pp学习是啥pll";

    static {

    }
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://blog.moyuyc.xyz:3306/shopping";
    private static final String USER = "root";
    private static final String PWD = "110114";
    protected static Connection conn;
    protected static Statement stmt;
    protected static PreparedStatement ps;
    protected static ResultSet rs;

    static {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void Close() {
        try {
            if (ps != null) {
                ps.close();
                ps = null;
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected static final Connection getConnInstance() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USER, PWD);
                return conn;
            }
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void test() {

    }


    public static String n() throws SQLException {
        Connection conn = getConnInstance();
        ps = conn.prepareStatement("SELECT * FROM `books`");
        rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        return "wu";
    }

    /*public static Object toBean(JSONObject jobject, Object object) {
        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                field.set(object, jobject.getString(field.getName()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }*/
    public static void main(String[] args) throws SQLException {
        System.out.println(A.n());
        System.out.println("sss");
    }

    public static JSONObject json() {

        JSONObject obj = new JSONObject();
        Name name = new Name("full---name", "dickname");
        // sssss
        obj.put("key", name);
        obj.put("key2", JSONObject.fromObject(name));
        return obj;
    }
}
