package com.Assignment.ShopManagement.repository;

import com.Assignment.ShopManagement.entity.Order;
import com.Assignment.ShopManagement.entity.OrderItem;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int save(Order order) {
        String sql = "INSERT INTO orders (user_id, order_date, total_price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, order.getUserId(), order.getOrderDate(), order.getTotalPrice());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
    }

    public void saveOrderItem(OrderItem item) {
        String sql = "INSERT INTO order_items (order_id, product_id, quantity, price, discount) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, item.getOrderId(), item.getProductId(), item.getQuantity(), item.getPrice(), item.getDiscount());
    }

    public List<Order> findByUserId(int userId) {
        String sql = "SELECT * FROM orders WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(Order.class));
    }

    public List<OrderItem> findItemsByOrderId(int orderId) {
        String sql = "SELECT * FROM order_items WHERE order_id = ?";
        return jdbcTemplate.query(sql, new Object[]{orderId}, new BeanPropertyRowMapper<>(OrderItem.class));
    }

    public List<Object[]> getMonthlySalesReport() {
        String sql = """
            SELECT c.name AS category,
                   COUNT(DISTINCT o.id) AS order_count,
                   SUM(oi.price * oi.quantity - oi.discount) AS total_revenue,
                   SUM(oi.quantity) AS total_quantity
            FROM orders o
            JOIN order_items oi ON o.id = oi.order_id
            JOIN products p ON oi.product_id = p.id
            JOIN categories c ON p.category_id = c.id
            WHERE MONTH(o.order_date) = MONTH(CURRENT_DATE())
              AND YEAR(o.order_date) = YEAR(CURRENT_DATE())
            GROUP BY c.name
        """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Object[]{
                rs.getString("category"),
                rs.getInt("order_count"),
                rs.getBigDecimal("total_revenue"),
                rs.getInt("total_quantity")
        });
    }
}
