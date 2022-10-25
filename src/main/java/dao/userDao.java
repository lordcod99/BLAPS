package dao;

import models.users;

import java.util.List;

public interface userDao {
    users saveUser(users user);
    users updateUSer(users user);
    users getbyID(users user);
    users deletebyID(users user);
    List<users> allUser();
}
