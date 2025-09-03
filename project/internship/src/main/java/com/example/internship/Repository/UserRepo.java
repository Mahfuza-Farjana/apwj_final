package com.example.internship.Repository;

import com.example.internship.Entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepo {
    public JdbcTemplate jdbc;

    public String GetAll = "SELECT * FROM user";
    public String FindByEmail = "SELECT * FROM user WHERE email=?";
    public String UpdateApproval = "UPDATE user SET approved=? WHERE id=?";
    public String Delete = "DELETE FROM user WHERE id=?";
    public String Insert = "INSERT INTO user (email, password, roleId, approved, createDate) VALUES (?, ?, ?, ?, ?)";

    public UserRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<User> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(User.class));
    }

    public User findByEmail(String email) {
        return jdbc.queryForObject(FindByEmail, new Object[]{email}, new BeanPropertyRowMapper<>(User.class));
    }

    public void updateApproval(int id, boolean approved) {
        jdbc.update(UpdateApproval, approved, id);
    }

    public void delete(int id) {
        jdbc.update(Delete, id);
    }

    public void insert(User user) {
        jdbc.update(Insert,
                user.getEmail(),
                user.getPassword(),
                user.getRoleId(),
                user.isApproved()
        );
    }

}
