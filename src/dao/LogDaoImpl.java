package dao;

import db.DbConnection;
import entity.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LogDaoImpl implements LogDao{


    @Override
    public List<Log> getLogListByUserId(Integer id) {
        DbConnection dbConnection=new DbConnection();
        List<Log> logs=new LinkedList<Log>();

        String sql ="select * from log where user_id = '"+id+"'";

        ResultSet rs= dbConnection.executeQuery(sql);
        try {
            while (rs.next()){
                Log log=new Log();
                log.setId(rs.getInt("id"));
                log.setTitle(rs.getString("title"));
                log.setContent(rs.getString("content"));
                log.setCreate_date(rs.getString("create_date"));
                logs.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnection.close();
        }

        return logs;
    }

    @Override
    public List<Log> getLogListByUserIdAndTitle(Integer id, String title) {
        DbConnection dbConnection=new DbConnection();
        List<Log> logs=new LinkedList<Log>();

        String sql ="select * from log where user_id = '"+id+"' and title like '%" + title + "%'";

        ResultSet rs= dbConnection.executeQuery(sql);
        try {
            while (rs.next()){
                Log log=new Log();
                log.setId(rs.getInt("id"));
                log.setTitle(rs.getString("title"));
                log.setContent(rs.getString("content"));
                log.setCreate_date(rs.getString("create_date"));
                logs.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.close();
        }

        return logs;
    }

    @Override
    public void addLog(Log log) {
        String sql="insert into log (title,content,user_id,create_date) values(?,?,?,now())";
        DbConnection dbConnection=new DbConnection();
        try {
            PreparedStatement pstmt=dbConnection.getCon().prepareStatement(sql);

            pstmt.setString(1,log.getTitle());
            pstmt.setString(2,log.getContent());
            pstmt.setInt(3,log.getUserId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnection.close();
        }



    }

    @Override
    public void updateLog(Log log) {
        String sql="update log set title=?,content=? where id = ?";
        DbConnection dbConnection=new DbConnection();
        try {
            PreparedStatement pstmt=dbConnection.getCon().prepareStatement(sql);

            pstmt.setString(1,log.getTitle());
            pstmt.setString(2,log.getContent());
            pstmt.setInt(3,log.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnection.close();
        }


    }

    @Override
    public void deleteLogById(Integer id) {
        String sql="delete from log where id = '"+id+"'";
        DbConnection dbConnection=new DbConnection();
        try {
            PreparedStatement pstmt=dbConnection.getCon().prepareStatement(sql);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.close();
        }


    }

    @Override
    public Log getLogById(Integer id) {
        Log log = new Log();
        String sql="select * from log where id = '"+id+"'";
        DbConnection dbConnection=new DbConnection();
        try {
            PreparedStatement pstmt=dbConnection.getCon().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                log.setId(rs.getInt("id"));
                log.setTitle(rs.getString("title"));
                log.setContent(rs.getString("content"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return log;
    }

    @Override
    public List<Log> getLogListByUsername(String username) {
        String sql = "select l.id,title,content,create_date from log l join user on l.user_id=user.id where user.username=?";
        List<Log> list = new ArrayList<>();
        DbConnection dbConnection=new DbConnection();
        try {
            PreparedStatement pstmt=dbConnection.getCon().prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Log log = new Log();
                log.setId(rs.getInt("l.id"));
                log.setTitle(rs.getString("title"));
                log.setContent(rs.getString("content"));
                log.setCreate_date(rs.getString("create_date"));
                list.add(log);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            dbConnection.close();
        }
        return list;
    }

    public static void main(String[] args) {
        LogDao logDao = new LogDaoImpl();
        List<Log> logList = logDao.getLogListByUsername("user");
        System.out.println(logList);

    }
}
