package dao;

import models.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class userDA implements userDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public users saveUser(users user) {
        return null;
    }

    @Override
    public users updateUSer(users user) {
        return null;
    }

    @Override
    public users getbyID(users user) {
        return null;
    }

    @Override
    public users deletebyID(users user) {
        return null;
    }

    @Override
    public List<users> allUser() {
        return null;
    }
}
