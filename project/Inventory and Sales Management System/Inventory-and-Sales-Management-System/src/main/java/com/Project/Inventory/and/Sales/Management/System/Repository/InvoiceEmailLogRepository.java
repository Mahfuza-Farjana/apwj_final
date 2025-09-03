package com.Project.Inventory.and.Sales.Management.System.Repository;

import com.Project.Inventory.and.Sales.Management.System.Entity.InvoiceEmailLog;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class InvoiceEmailLogRepository {
    private final JdbcTemplate jdbcTemplate;

    public InvoiceEmailLogRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(InvoiceEmailLog log) {
        jdbcTemplate.update("INSERT INTO invoice_email_log (sale_id, email_to, sent_at) VALUES (?, ?, ?)",
                log.getSaleId(), log.getEmailTo(), log.getSentAt());
    }

    public List<InvoiceEmailLog> getBySaleId(int saleId) {
        return jdbcTemplate.query("SELECT * FROM invoice_email_log WHERE sale_id = ?", new Object[]{saleId}, new BeanPropertyRowMapper<>(InvoiceEmailLog.class));
    }
}
