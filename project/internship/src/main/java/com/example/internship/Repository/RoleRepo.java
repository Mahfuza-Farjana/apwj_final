package com.example.internship.Repository;

import com.example.internship.Entity.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class RoleRepo {
    public JdbcTemplate jdbc;

    public String GetAll = "SELECT * FROM role";

    public RoleRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Role> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(Role.class));
    }
}
