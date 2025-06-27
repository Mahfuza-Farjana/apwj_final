package com.Project.LibraryManagement.Repository;

import com.Project.LibraryManagement.Entity.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CategoryRepository {
    private JdbcTemplate jdbcTemplate;

    public CategoryRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Category> getAll() {
        return jdbcTemplate.query("SELECT * FROM categories", new BeanPropertyRowMapper<>(Category.class));
    }

    public Category getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM categories WHERE id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Category.class));
    }

    public void save(Category category) {
        jdbcTemplate.update("INSERT INTO categories (name) VALUES (?)", category.getName());
    }

    public void update(Category category) {
        jdbcTemplate.update("UPDATE categories SET name = ? WHERE id = ?", category.getName(), category.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM categories WHERE id = ?", id);
    }
}
