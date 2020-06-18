package dao;

import db.DbConnection;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao{


    @Override
    public void register(User user) {
        DbConnection dbConnection=new DbConnection();
        String sql="insert into user (username,password,register_date,role) values(?,?,now(),2)";
        try {
            PreparedStatement pstmt=dbConnection.getCon().prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
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
    public User checkLogin(User user) {
        DbConnection dbConnection=new DbConnection();

        String sql ="select * from user where username = '"+user.getUsername()+"'";
        User res = null;
        ResultSet rs= dbConnection.executeQuery(sql);
        try {
            if(rs.next()){
                res = new User();
                res.setUsername(user.getUsername());
                res.setId(rs.getInt("id"));
                res.setRole(rs.getInt("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void updatePassword(User user) {
        DbConnection dbConnection=new DbConnection();
        String sql="update user set password = ? where id = '"+user.getId()+"'";

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
        DbConnection dbConnection=new DbConnection();
        List<User> userList=new LinkedList<User>();

        String sql ="select * from user where role = 2";

        ResultSet rs= dbConnection.executeQuery(sql);
        try {
            while (rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
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
        DbConnection dbConnection=new DbConnection();
        String sql ="select * from user where role = 2 and username like '%"+name+"%'";

        ResultSet rs= dbConnection.executeQuery(sql);
        try {
            while (rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
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
        DbConnection dbConnection=new DbConnection();
        try {
            PreparedStatement pstmt=dbConnection.getCon().prepareStatement(sql);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dbConnection.close();
    }
}
