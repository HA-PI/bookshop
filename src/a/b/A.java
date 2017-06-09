package a.b;

import org.json.simple.JSONObject;

import java.sql.*;

/**
 * Created by moyu on 2017/6/8.
 */
public class A {
    public String a = "hs哈";


    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/gp";
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

    public static void main(String[] args) throws SQLException {
        Connection conn = getConnInstance();
        ps = conn.prepareStatement("SELECT * FROM `face_import`");
        rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("size: " + rs.getFetchSize());
        }
    }

    public static int n() throws SQLException {
        Connection conn = getConnInstance();
        ps = conn.prepareStatement("SELECT * FROM `face_import`");
        rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getFetchSize();
        }
        return 0;
    }

    public static JSONObject json() {
        JSONObject obj = new JSONObject();
        Name name = new Name("fullname", "dickname");
        obj.put("key", name);
        return obj;
    }
}
