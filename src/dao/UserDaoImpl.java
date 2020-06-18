package dao;

import entity.User;

import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public void register(User user) {

    }

    /**
     *
     * @return 1 管理员 2 普通用户 0 登陆失败
     */
    @Override
    public int checkLogin(User user) {
        return 0;
    }

    @Override
    public void updatePassword(User user) {

    }

    /**
     * @return 只查询普通用户
     */
    @Override
    public List<User> getUserList() {
        return null;
    }

    /**
     *
     * @param name 关键字
     * @return 只查询普通用户
     */
    @Override
    public List<User> getUserByName(String name) {
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {

    }
}
