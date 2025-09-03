package com.example.internship.Repository;

import com.example.internship.Entity.Application;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ApplicationRepo {
    public JdbcTemplate jdbc;

    public String GetByStudentId = "SELECT * FROM application WHERE student_id=?";
    public String GetByInternshipId = "SELECT * FROM application WHERE internship_id=?";
    public String Insert = "INSERT INTO application (student_id, internship_id, status_id, application_date) VALUES (?, ?, ?, ?)";
    public String UpdateStatus = "UPDATE application SET status_id=? WHERE id=?";
    public String CountAcceptedApplicationsByCompany = "SELECT COUNT(*) FROM application a JOIN internship i ON a.internship_id = i.id WHERE i.company_id = ? AND a.status_id = ?";

    public ApplicationRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Application> getByStudentId(int studentId) {
        return jdbc.query(GetByStudentId, new Object[]{studentId}, new BeanPropertyRowMapper<>(Application.class));
    }

    public List<Application> getByInternshipId(int internshipId) {
        return jdbc.query(GetByInternshipId, new Object[]{internshipId}, new BeanPropertyRowMapper<>(Application.class));
    }

    public void insert(Application app) {
        jdbc.update(Insert, app.getStudentId(), app.getInternshipId(), app.getStatusId(), app.getApplicationDate());
    }

    public void updateStatus(int applicationId, int statusId) {
        jdbc.update(UpdateStatus, statusId, applicationId);
    }

    public int countAcceptedApplicationsByCompany(int companyId, int acceptedStatusId) {
        return jdbc.queryForObject(CountAcceptedApplicationsByCompany, new Object[]{companyId, acceptedStatusId}, Integer.class);
    }
}
