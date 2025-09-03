package com.Project.Inventory.and.Sales.Management.System.Repository;

import com.Project.Inventory.and.Sales.Management.System.Entity.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Product> getAll() {
        return jdbcTemplate.query("SELECT * FROM product", new BeanPropertyRowMapper<>(Product.class));
    }

    public Product getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM product WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Product.class));
    }

    public void save(Product product) {
        jdbcTemplate.update("INSERT INTO product (name, category_id, price, quantity, expiry_date, is_available) VALUES (?, ?, ?, ?, ?, ?)",
                product.getName(), product.getCategoryId(), product.getPrice(), product.getQuantity(), product.getExpiryDate(), product.getAvailable());
    }

    public void update(Product product) {
        jdbcTemplate.update("UPDATE product SET name = ?, category_id = ?, price = ?, quantity = ?, expiry_date = ?, is_available = ? WHERE id = ?",
                product.getName(), product.getCategoryId(), product.getPrice(), product.getQuantity(), product.getExpiryDate(), product.getAvailable(), product.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM products WHERE id = ?", id);
    }

    public List<Product> getLowStock(int threshold) {
        return jdbcTemplate.query("SELECT * FROM product WHERE quantity < ?", new Object[]{threshold}, new BeanPropertyRowMapper<>(Product.class));
    }
}
