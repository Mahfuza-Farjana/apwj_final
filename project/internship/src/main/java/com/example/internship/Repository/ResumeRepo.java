package com.example.internship.Repository;

import com.example.internship.Entity.Resume;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ResumeRepo {
    public JdbcTemplate jdbc;

    public String GET_BY_STUDENT_ID = "SELECT * FROM resume WHERE student_id = ?";
    public String GET_BY_COMPANY_ID = "SELECT * FROM resume WHERE company_id = ?";
    public String INSERT = "INSERT INTO resume (student_id, company_id, resume_location, uploaded_date) VALUES (?, ?, ?, ?)";
    public String UPDATE = "UPDATE resume SET resume_location = ?, uploaded_date = ? WHERE id = ?";
    public String DELETE = "DELETE FROM resume WHERE id = ?";

    public ResumeRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Resume> getByStudentId(int studentId) {
        return jdbc.query(GET_BY_STUDENT_ID, new Object[]{studentId}, new BeanPropertyRowMapper<>(Resume.class));
    }

    public List<Resume> getByCompanyId(int companyId) {
        return jdbc.query(GET_BY_COMPANY_ID, new Object[]{companyId}, new BeanPropertyRowMapper<>(Resume.class));
    }

    public void insert(Resume resume) {
        jdbc.update(INSERT,
                resume.getStudentId(),
                resume.getCompanyId(),
                resume.getResumeLocation(),
                resume.getUploadedDate());
    }

    public void update(Resume resume) {
        jdbc.update(UPDATE,
                resume.getResumeLocation(),
                resume.getUploadedDate(),
                resume.getId());
    }

    public void delete(int id) {
        jdbc.update(DELETE, id);
    }
}
