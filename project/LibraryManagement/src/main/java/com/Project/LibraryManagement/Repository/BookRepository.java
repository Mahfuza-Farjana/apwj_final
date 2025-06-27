package com.Project.LibraryManagement.Repository;

import com.Project.LibraryManagement.Entity.Book;
import com.Project.LibraryManagement.Entity.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BookRepository {
    private JdbcTemplate jdbcTemplate;

    public BookRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Book> getAll() {
        return jdbcTemplate.query("SELECT * FROM books", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM books WHERE id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO books (title, author, quantity, is_available, category_id) VALUES (?, ?, ?, ?, ?)",
                book.getTitle(), book.getAuthor(), book.getQuantity(), book.getIsAvailable(), book.getCategoryId());
    }

    public void update(Book book) {
        jdbcTemplate.update("UPDATE books SET title = ?, author = ?, quantity = ?, is_available = ?, category_id = ? WHERE id = ?",
                book.getTitle(), book.getAuthor(), book.getQuantity(), book.getIsAvailable(), book.getCategoryId(), book.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);
    }


    public Book getBookWithCategory(int id) {
        String sql = """
                SELECT b.id, b.title, b.author, b.quantity, b.is_available, c.id AS categoryId, c.name AS categoryName
                FROM books b
                LEFT JOIN categories c ON b.category_id = c.id
                WHERE b.id = ?
            """;

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setQuantity(rs.getInt("quantity"));
            book.setIsAvailable(rs.getBoolean("is_available"));
            book.setCategoryId(rs.getInt("categoryId"));

            Category category = new Category();
            category.setId(rs.getInt("categoryId"));
            category.setName(rs.getString("categoryName"));

            return book;
        });
    }
}
