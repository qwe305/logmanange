package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection con = null;
    private final String user = "root";
    private final String password = "QWER1234";

    public Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            return null;
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logmanage?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8");
        } catch (SQLException throwables) {
            return null;
        }
        return con;
    }

    public void close() {
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
