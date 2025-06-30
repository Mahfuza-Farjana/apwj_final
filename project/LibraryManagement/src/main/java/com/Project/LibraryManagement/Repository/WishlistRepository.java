package com.Project.LibraryManagement.Repository;

import com.Project.LibraryManagement.Entity.Wishlist;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class WishlistRepository {

    private final JdbcTemplate jdbcTemplate;

    public WishlistRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Wishlist> getByUserId(int userId) {
        return jdbcTemplate.query("SELECT * FROM wishlists WHERE user_id = ?",
                new Object[]{userId}, new BeanPropertyRowMapper<>(Wishlist.class));
    }

    public void add(int userId, int bookId) {
        jdbcTemplate.update("INSERT INTO wishlists (user_id, book_id) VALUES (?, ?)", userId, bookId);
    }

    public void remove(int userId, int bookId) {
        jdbcTemplate.update("DELETE FROM wishlists WHERE user_id = ? AND book_id = ?", userId, bookId);
    }

}
