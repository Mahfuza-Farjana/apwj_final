package com.Project.Inventory.and.Sales.Management.System.Repository;

import com.Project.Inventory.and.Sales.Management.System.Entity.SaleItem;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SaleItemRepository {
    private final JdbcTemplate jdbcTemplate;

    public SaleItemRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<SaleItem> getBySaleId(int saleId) {
        return jdbcTemplate.query("SELECT * FROM sale_item WHERE sale_id = ?", new Object[]{saleId}, new BeanPropertyRowMapper<>(SaleItem.class));
    }

    public List<SaleItem> getAll() {
        return jdbcTemplate.query("SELECT * FROM sale_item", new BeanPropertyRowMapper<>(SaleItem.class));
    }

    public void save(SaleItem item) {
        jdbcTemplate.update("INSERT INTO sale_item (sale_id, product_id, quantity, price) VALUES (?, ?, ?, ?)",
                item.getSaleId(), item.getProductId(), item.getQuantity(), item.getPrice());
    }

    public void update(SaleItem item) {
        jdbcTemplate.update("UPDATE sale_item SET sale_id = ?, product_id = ?, quantity = ?, price = ? WHERE id = ?",
                item.getSaleId(), item.getProductId(), item.getQuantity(), item.getPrice(), item.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM sale_item WHERE id = ?", id);
    }
}
