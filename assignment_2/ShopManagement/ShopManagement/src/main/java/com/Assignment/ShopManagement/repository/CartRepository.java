package com.Assignment.ShopManagement.repository;

import com.Assignment.ShopManagement.entity.CartItem;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CartRepository {
    private final JdbcTemplate jdbcTemplate;

    public CartRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addOrUpdate(int userId, int productId, int quantity) {
        String checkSql = "SELECT COUNT(*) FROM cart_items WHERE user_id = ? AND product_id = ?";
        Integer count = jdbcTemplate.queryForObject(checkSql, Integer.class, userId, productId);
        if (count != null && count > 0) {
            String updateSql = "UPDATE cart_items SET quantity = ? WHERE user_id = ? AND product_id = ?";
            jdbcTemplate.update(updateSql, quantity, userId, productId);
        } else {
            String insertSql = "INSERT INTO cart_items (user_id, product_id, quantity) VALUES (?, ?, ?)";
            jdbcTemplate.update(insertSql, userId, productId, quantity);
        }
    }

    public int remove(int userId, int productId) {
        String sql = "DELETE FROM cart_items WHERE user_id = ? AND product_id = ?";
        return jdbcTemplate.update(sql, userId, productId);
    }

    public List<CartItem> getCart(int userId) {
        String sql = "SELECT * FROM cart_items WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(CartItem.class));
    }
}
