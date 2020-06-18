package dao;

import db.DbConnection;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    DbConnection dbConnection=new DbConnection();

    @Override
    public void register(User user) {
        String sql="insert into user (username,password,register_date,role) values(?,?,?,?)";

        try {
            PreparedStatement pstmt=dbConnection.getCon().prepareStatement(sql);

            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getRegister_date());
            pstmt.setInt(4,2);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.close();
    }

    /**
     *
     * @return 1 管理员 2 普通用户 0 登陆失败
     */
    @Override
    public int checkLogin(User user) {

        int flag=0;

        String sql ="select * from user where username = '"+user.getUsername()+"'";

        ResultSet rs= dbConnection.executeQuery(sql);
        try {
            while (rs.next()){
                flag=rs.getInt("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public void updatePassword(User user) {

        String sql="update user set password where id = '"+user.getId()+"'";

        try {
            PreparedStatement pstmt=dbConnection.getCon().prepareStatement(sql);

            pstmt.setString(1,user.getPassword());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dbConnection.close();

    }

    /**
     * @return 只查询普通用户
     */
    @Override
    public List<User> getUserList() {

        List<User> userList=new LinkedList<User>();

        String sql ="select * from user where role = 2";

        ResultSet rs= dbConnection.executeQuery(sql);
        try {
            while (rs.next()){
                User user=new User();

                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRegister_date(rs.getString("register_date"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.close();
        return userList;
    }

    /**
     *
     * @param name 关键字
     * @return 只查询普通用户
     */
    @Override
    public List<User> getUserByName(String name) {
        List<User> userList=new LinkedList<User>();

        String sql ="select * from user where role = 2 and username = '"+name+"'";

        ResultSet rs= dbConnection.executeQuery(sql);
        try {
            while (rs.next()){
                User user=new User();

                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRegister_date(rs.getString("register_date"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.close();
        return userList;
    }

    @Override
    public void deleteUserById(Integer id) {
        String sql="delete from user where id = '"+id+"'";

        try {
            PreparedStatement pstmt=dbConnection.getCon().prepareStatement(sql);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dbConnection.close();
    }
}
