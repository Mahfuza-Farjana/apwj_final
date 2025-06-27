package com.Project.LibraryManagement.Repository;

import com.Project.LibraryManagement.Entity.BorrowRecord;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

@Repository
public class BorrowRecordRepository {
    private final JdbcTemplate jdbcTemplate;

    public BorrowRecordRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void borrowBook(BorrowRecord record) {
        jdbcTemplate.update("""
            INSERT INTO borrow_records (user_id, book_id, borrow_date, due_date, status)
            VALUES (?, ?, ?, ?, ?)""",
                record.getUserId(), record.getBookId(), record.getBorrowDate(), record.getDueDate(), record.getStatus());
    }

    public void returnBook(int recordId, LocalDate returnDate) {
        jdbcTemplate.update("""
            UPDATE borrow_records 
            SET return_date = ?, status = 'RETURNED' 
            WHERE id = ?""", returnDate, recordId);
    }

    public List<BorrowRecord> getBorrowedByUser(int userId) {
        return jdbcTemplate.query("SELECT * FROM borrow_records WHERE user_id = ?", new Object[]{userId},
                new BeanPropertyRowMapper<>(BorrowRecord.class));
    }

    public List<BorrowRecord> getOverdueRecords(LocalDate today) {
        return jdbcTemplate.query("""
            SELECT * FROM borrow_records 
            WHERE status = 'BORROWED' AND due_date < ?""", new Object[]{today},
                new BeanPropertyRowMapper<>(BorrowRecord.class));
    }
}
