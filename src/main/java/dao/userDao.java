package dao;

import models.users;

import java.util.List;

//hello

public interface userDao {
    void saveUser(users user);
    void updateUSer(users user);
    users getbyID(int id);
    users getbyUsername(String username);
    void deletebyID(int id);
    void deletebyUsername(String username);
    void changePassword(String username,String password);
    List<users> allUser();
}
