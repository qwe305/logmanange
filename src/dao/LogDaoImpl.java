package dao;

import db.DbConnection;
import entity.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class LogDaoImpl implements LogDao{
    DbConnection dbConnection=new DbConnection();

    @Override
    public List<Log> getLogListByUserId(Integer id) {

        List<Log> logs=new LinkedList<Log>();

        String sql ="select * from log where user_id = '"+id+"'";

        ResultSet rs= dbConnection.executeQuery(sql);
        try {
            while (rs.next()){
                Log log=new Log();
                log.setTitle(rs.getString("title"));
                log.setContent(rs.getString("content"));
                log.setCreate_date(rs.getString("create_date"));
                logs.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.close();
        return logs;
    }

    @Override
    public List<Log> getLogListByUserIdAndTitle(Integer id, String title) {
        List<Log> logs=new LinkedList<Log>();

        String sql ="select * from log where user_id = '"+id+"' and title = '"+title+"'";

        ResultSet rs= dbConnection.executeQuery(sql);
        try {
            while (rs.next()){
                Log log=new Log();
                log.setTitle(rs.getString("title"));
                log.setContent(rs.getString("content"));
                log.setCreate_date(rs.getString("create_date"));
                logs.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.close();
        return logs;
    }

    @Override
    public void addLog(Log log) {
        String sql="insert into log (title,content,user_id) values(?,?,?)";

        try {
            PreparedStatement pstmt=dbConnection.getCon().prepareStatement(sql);

            pstmt.setString(1,log.getTitle());
            pstmt.setString(2,log.getContent());
            pstmt.setInt(3,log.getUserId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dbConnection.close();

    }

    @Override
    public void updateLog(Log log) {
        String sql="update log set title=?,content=?,user_id=? where id = '"+log.getId()+"'";

        try {
            PreparedStatement pstmt=dbConnection.getCon().prepareStatement(sql);

            pstmt.setString(1,log.getTitle());
            pstmt.setString(2,log.getContent());
            pstmt.setInt(3,log.getUserId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dbConnection.close();
    }

    @Override
    public void deleteLogById(Integer id) {
        String sql="delete from log where id = '"+id+"'";

        try {
            PreparedStatement pstmt=dbConnection.getCon().prepareStatement(sql);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dbConnection.close();
    }
}
