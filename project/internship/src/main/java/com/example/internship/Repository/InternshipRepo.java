package com.example.internship.Repository;

import com.example.internship.Entity.Internship;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

@Repository
public class InternshipRepo {
    public JdbcTemplate jdbc;

    public String GetAll = "SELECT * FROM internship";
    public String Insert = "INSERT INTO internship (title, company_id, category_id, description, deadline, active, posted_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public String Update = "UPDATE internship SET title=?, category_id=?, description=?, deadline=?, active=? WHERE id=?";
    public String Delete = "DELETE FROM internship WHERE id=?";
    public String SearchByTitle = "SELECT * FROM internship WHERE LOWER(title) LIKE LOWER(?)";
    public String GetUpcomingDeadlines = "SELECT * FROM internship WHERE deadline >= CURRENT_DATE AND deadline <= ?";

    public InternshipRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Internship> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(Internship.class));
    }

    public void insert(Internship i) {
        jdbc.update(Insert, i.getTitle(), i.getCompanyId(), i.getCategoryId(), i.getDescription(), i.getDeadline(), i.isActive(), i.getPostedDate());
    }

    public void update(Internship i) {
        jdbc.update(Update, i.getTitle(), i.getCategoryId(), i.getDescription(), i.getDeadline(), i.isActive(), i.getId());
    }

    public void delete(int id) {
        jdbc.update(Delete, id);
    }

    public List<Internship> searchByTitle(String keyword) {
        return jdbc.query(SearchByTitle, new Object[]{"%" + keyword + "%"}, new BeanPropertyRowMapper<>(Internship.class));
    }

    public List<Internship> getUpcomingDeadlines(LocalDate withinDate) {
        return jdbc.query(GetUpcomingDeadlines, new Object[]{withinDate}, new BeanPropertyRowMapper<>(Internship.class));
    }
}
