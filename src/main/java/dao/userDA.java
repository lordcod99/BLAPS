package dao;

import models.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

//bye
@Repository
public class userDA implements userDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    int strength=10;
    @Override
    public void saveUser(users user) {
        user.setPass_word(bCryptPasswordEncoder.encode(user.getPass_word()));
        String sqlst="INSERT INTO User (id,F_name,S_name,user_name,pass_word) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlst,user.getUser_name(),user.getF_name(),user.getS_name(),user.getId(),user.getPass_word());
//        return null;
    }

    @Override
    public void updateUSer(users user) {
        String sql = "UPDATE User SET F_name = ?, S_name = ? WHERE user_name = ?";
        jdbcTemplate.update(sql, user.getF_name(), user.getS_name(),user.getUser_name());
//        return null;
    }

    @Override
    public users getbyID(int id) {
        try {
            String sql = "SELECT * FROM User WHERE id = ?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(users.class), new Object[] { id });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public users getbyUsername(String username) {
        try {
            String sql = "SELECT * FROM User WHERE user_name = ?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(users.class), new Object[] { username });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
//        String sql="SELECT * FROM users WHERE user_name=?";
//        return jdbcTemplate.queryForObject(sql,(rs, rowNum) -> {
//            return new users(rs.getInt("id"),rs.getString("F_name"),rs.getString("S_name"),rs.getString("user_name"),rs.getString("pass_word"));
//        });
    }

    @Override
    public void deletebyID(int id) {
        String sql = "DELETE FROM User WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void deletebyUsername(String username) {
        String sql = "DELETE FROM User WHERE user_name = ?";
        jdbcTemplate.update(sql, username);
    }

    @Override
    public void changePassword(String username, String password) {
        String Password = bCryptPasswordEncoder.encode(password);
        String sql = "UPDATE User SET pass_word = ? WHERE user_name = ?";
        jdbcTemplate.update(sql, Password, username);
    }

    @Override
    public List<users> allUser() {
        String sql="SELECT * FROM users";
        return jdbcTemplate.query(sql,(rs,rowNum)->{return new users(rs.getInt("id"),rs.getString("F_name"),rs.getString("S_name"),rs.getString("user_name"),rs.getString("pass_word"));});
    }
}
