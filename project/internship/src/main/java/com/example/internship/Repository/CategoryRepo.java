package com.example.internship.Repository;

import com.example.internship.Entity.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CategoryRepo {
    public JdbcTemplate jdbc;

    public String GetAll = "SELECT * FROM category";
    public String Insert = "INSERT INTO category (name, description) VALUES (?, ?)";
    public String Delete = "DELETE FROM category WHERE id=?";

    public CategoryRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Category> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(Category.class));
    }

    public void insert(Category c) {
        jdbc.update(Insert, c.getName(), c.getDescription());
    }

    public void delete(int id) {
        jdbc.update(Delete, id);
    }
}
