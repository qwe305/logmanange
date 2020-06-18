package db;

import java.sql.*;

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
            con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/logmanage?" +
                            "serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8",user,password);
        } catch (SQLException throwables) {
            return null;
        }
        return con;
    }

    //查询结果集
    public ResultSet executeQuery(String query){
        ResultSet rs=null;

        try {
            rs=getCon().createStatement().executeQuery(query);
        } catch (SQLException e) {
            System.out.println("executeQuery:"+e);
        }
        return rs;
    }

    //修改数据库
    public void executeUpdate(String command){

        try {
            getCon().createStatement().executeUpdate(command);
        } catch (SQLException e) {
            System.out.println("executeUpdate:"+e);
        }
    }

    //关闭数据库
    public void close() {
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
