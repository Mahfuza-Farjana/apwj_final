package com.Project.LibraryManagement.Repository;

import com.Project.LibraryManagement.Entity.CartItem;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CartItemRepository {
    private final JdbcTemplate jdbcTemplate;

    public CartItemRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<CartItem> getByUserId(int userId) {
        return jdbcTemplate.query("SELECT * FROM cart_items WHERE user_id = ?",
                new Object[]{userId}, new BeanPropertyRowMapper<>(CartItem.class));
    }

    public void add(int userId, int bookId) {
        jdbcTemplate.update("INSERT INTO cart_items (user_id, book_id) VALUES (?, ?)", userId, bookId);
    }

    public void remove(int userId, int bookId) {
        jdbcTemplate.update("DELETE FROM cart_items WHERE user_id = ? AND book_id = ?", userId, bookId);
    }

    public void clearCart(int userId) {
        jdbcTemplate.update("DELETE FROM cart_items WHERE user_id = ?", userId);
    }
}
