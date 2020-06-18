package dao;

import entity.Log;

import java.util.List;

public interface LogDao {
    List<Log> getLogListByUserId(Integer id);

    List<Log> getLogListByUserIdAndTitle(Integer id,String title);

    void addLog(Log log);

    void updateLog(Log log);

    void deleteLogById(Integer id);

    Log getLogById(Integer id);

    List<Log> getLogListByUsername(String username);
}
