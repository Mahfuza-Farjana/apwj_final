package com.example.internship.Repository;

import com.example.internship.Entity.OfferLetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OfferLetterRepo {
    public JdbcTemplate jdbc;

    public String GetByStudentId = "SELECT * FROM offerletter WHERE student_id=?";
    public String GetByCompanyId = "SELECT * FROM offerletter WHERE company_id=?";
    public String Insert = "INSERT INTO offerletter (company_id, student_id, subject, description, sending_date) VALUES (?, ?, ?, ?, ?)";

    public OfferLetterRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<OfferLetter> getByStudentId(int studentId) {
        return jdbc.query(GetByStudentId, new Object[]{studentId}, new BeanPropertyRowMapper<>(OfferLetter.class));
    }

    public List<OfferLetter> getByCompanyId(int companyId) {
        return jdbc.query(GetByCompanyId, new Object[]{companyId}, new BeanPropertyRowMapper<>(OfferLetter.class));
    }

    public void insert(OfferLetter offer) {
        jdbc.update(Insert, offer.getCompanyId(), offer.getStudentId(), offer.getSubject(), offer.getDescription(), offer.getSendingDate());
    }
}
