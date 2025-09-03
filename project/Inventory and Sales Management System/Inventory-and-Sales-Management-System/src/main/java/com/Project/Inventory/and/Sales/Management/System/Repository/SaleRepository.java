package com.Project.Inventory.and.Sales.Management.System.Repository;

import com.Project.Inventory.and.Sales.Management.System.Entity.Sale;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SaleRepository {

    private final JdbcTemplate jdbcTemplate;

    public SaleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Save a new Sale
    public void save(Sale sale) {
        String sql = "INSERT INTO sale (customer_id, discount_id, total_amount, sale_date) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                sale.getCustomerId(),
                sale.getDiscountId(), // can be null
                sale.getTotalAmount(),
                sale.getSaleDate());
    }

    // Get the last inserted ID (for MySQL, PostgreSQL, etc.)
    public int getLastInsertedId() {
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
    }

    // Get sale by ID
    public Sale getById(int id) {
        String sql = "SELECT * FROM sale WHERE id = ?";
        List<Sale> results = jdbcTemplate.query(sql, new Object[]{id}, this::mapRowToSale);
        return results.isEmpty() ? null : results.get(0);
    }

    // Get all sales
    public List<Sale> getAll() {
        String sql = "SELECT * FROM sale ORDER BY sale_date DESC";
        return jdbcTemplate.query(sql, this::mapRowToSale);
    }

    // Delete a sale by ID
    public void delete(int id) {
        String sql = "DELETE FROM sale WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Custom RowMapper to map manually
    private Sale mapRowToSale(ResultSet rs, int rowNum) throws SQLException {
        Sale sale = new Sale();
        sale.setId(rs.getInt("id"));
        sale.setCustomerId(rs.getInt("customer_id"));
        sale.setDiscountId(rs.getObject("discount_id") != null ? rs.getInt("discount_id") : null);
        sale.setTotalAmount(rs.getDouble("total_amount"));
        sale.setSaleDate(rs.getTimestamp("sale_date").toLocalDateTime());
        return sale;
    }
}
