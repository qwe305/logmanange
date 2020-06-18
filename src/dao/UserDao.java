package dao;

import entity.User;

import java.util.List;

public interface UserDao {

    void register(User user);

    User checkLogin(User user);

    void updatePassword(User user);

    List<User> getUserList();

    List<User> getUserByName(String name);

    void deleteUserById(Integer id);
}
