package com.Project.Inventory.and.Sales.Management.System.Repository;

import com.Project.Inventory.and.Sales.Management.System.Entity.Discount;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DiscountRepository {
    private final JdbcTemplate jdbcTemplate;

    public DiscountRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Discount> getAll() {
        return jdbcTemplate.query("SELECT * FROM discount", new BeanPropertyRowMapper<>(Discount.class));
    }

    public Discount getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM discount WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Discount.class));
    }

    public List<Discount> getActiveDiscounts() {
        return jdbcTemplate.query("SELECT * FROM discount WHERE CURDATE() BETWEEN start_date AND end_date", new BeanPropertyRowMapper<>(Discount.class));
    }

    public void save(Discount discount) {
        jdbcTemplate.update("INSERT INTO discount (percentage, start_date, end_date, description) VALUES (?, ?, ?, ?)",
                discount.getPercentage(), discount.getStartDate(), discount.getEndDate(), discount.getDescription());
    }

    public void update(Discount discount) {
        jdbcTemplate.update("UPDATE discount SET percentage = ?, start_date = ?, end_date = ?, description = ? WHERE id = ?",
                discount.getPercentage(), discount.getStartDate(), discount.getEndDate(), discount.getDescription(), discount.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM discount WHERE id = ?", id);
    }
}
