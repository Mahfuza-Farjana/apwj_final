package com.Project.LibraryManagement.Repository;

import com.Project.LibraryManagement.Entity.Reservation;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ReservationRepository {
    private final JdbcTemplate jdbcTemplate;

    public ReservationRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void reserveBook(Reservation reservation) {
        jdbcTemplate.update("INSERT INTO reservations (user_id, book_id, reserved_at, status) VALUES (?, ?, ?, ?)",
                reservation.getUserId(), reservation.getBookId(), reservation.getReservedAt(), reservation.getStatus());
    }

    public List<Reservation> getByUserId(int userId) {
        return jdbcTemplate.query("SELECT * FROM reservations WHERE user_id = ?",
                new Object[]{userId}, new BeanPropertyRowMapper<>(Reservation.class));
    }

    public void cancel(int id) {
        jdbcTemplate.update("UPDATE reservations SET status = 'CANCELLED' WHERE id = ?", id);
    }

    public void fulfill(int id) {
        jdbcTemplate.update("UPDATE reservations SET status = 'FULFILLED' WHERE id = ?", id);
    }
}
