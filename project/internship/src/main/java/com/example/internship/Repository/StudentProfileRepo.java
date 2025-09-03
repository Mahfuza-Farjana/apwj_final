package com.example.internship.Repository;

import com.example.internship.Entity.StudentProfile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class StudentProfileRepo {
    public JdbcTemplate jdbc;

    public String GetByUserId = "SELECT * FROM studentprofile WHERE user_id=?";
    public String Update = "UPDATE studentprofile SET name=?, university=?, major=?, passing_year=? WHERE user_id=?";

    public StudentProfileRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public StudentProfile getByUserId(int userId) {
        return jdbc.queryForObject(GetByUserId, new Object[]{userId}, new BeanPropertyRowMapper<>(StudentProfile.class));
    }

    public void update(StudentProfile sp) {
        jdbc.update(Update, sp.getName(), sp.getUniversity(), sp.getMajor(), sp.getPassingYear(), sp.getUserId());
    }
}
