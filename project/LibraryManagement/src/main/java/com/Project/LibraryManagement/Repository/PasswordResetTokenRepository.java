package com.Project.LibraryManagement.Repository;

import com.Project.LibraryManagement.Entity.PasswordResetToken;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;

@Repository
public class PasswordResetTokenRepository {
    private final JdbcTemplate jdbcTemplate;

    public PasswordResetTokenRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(PasswordResetToken token) {
        jdbcTemplate.update("""
            INSERT INTO password_reset_tokens (user_id, reset_token, created_at, expires_at) 
            VALUES (?, ?, ?, ?)""",
                token.getUserId(), token.getResetToken(), token.getCreatedAt(), token.getExpiresAt());
    }

    public PasswordResetToken findByToken(String token) {
        return jdbcTemplate.queryForObject("SELECT * FROM password_reset_tokens WHERE reset_token = ?",
                new Object[]{token}, new BeanPropertyRowMapper<>(PasswordResetToken.class));
    }

    public void deleteExpired(LocalDateTime now) {
        jdbcTemplate.update("DELETE FROM password_reset_tokens WHERE expires_at < ?", now);
    }
}
