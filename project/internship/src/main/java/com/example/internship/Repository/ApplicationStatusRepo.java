package com.example.internship.Repository;

import com.example.internship.Entity.ApplicationStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ApplicationStatusRepo {
    public JdbcTemplate jdbc;

    public String GetAll = "SELECT * FROM applicationstatus";
    public String Insert = "INSERT INTO applicationstatus (name) VALUES (?)";
    public String Delete = "DELETE FROM applicationstatus WHERE id=?";

    public ApplicationStatusRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<ApplicationStatus> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(ApplicationStatus.class));
    }

    public void insert(ApplicationStatus status) {
        jdbc.update(Insert, status.getName());
    }

    public void delete(int id) {
        jdbc.update(Delete, id);
    }
}
