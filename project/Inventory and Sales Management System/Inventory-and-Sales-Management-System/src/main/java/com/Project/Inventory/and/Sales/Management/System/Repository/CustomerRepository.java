package com.Project.Inventory.and.Sales.Management.System.Repository;

import com.Project.Inventory.and.Sales.Management.System.Entity.Customer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CustomerRepository {
    private final JdbcTemplate jdbcTemplate;

    public CustomerRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Customer> getAll() {
        return jdbcTemplate.query("SELECT * FROM customer", new BeanPropertyRowMapper<>(Customer.class));
    }

    public Customer getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM customer WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Customer.class));
    }

    public void save(Customer user) {
        jdbcTemplate.update("INSERT INTO customer (username, email, password, role) VALUES (?, ?, ?, ?)",
                user.getUsername(), user.getEmail(), user.getPassword(), user.getRole().name());
    }

    public void update(Customer user) {
        jdbcTemplate.update("UPDATE customer SET username = ?, email = ?, password = ?, role = ? WHERE id = ?",
                user.getUsername(), user.getEmail(), user.getPassword(), user.getRole().name(), user.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM customer WHERE id = ?", id);
    }
}
