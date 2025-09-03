package com.example.internship.Repository;

import com.example.internship.Entity.CompanyProfile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CompanyProfileRepo {
    public JdbcTemplate jdbc;

    public String GetByUserId = "SELECT * FROM companyprofile WHERE user_id=?";
    public String Update = "UPDATE companyprofile SET name=?, industry=?, website=?, contact_person=?, location=?, phone_no=? WHERE user_id=?";

    public CompanyProfileRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public CompanyProfile getByUserId(int userId) {
        return jdbc.queryForObject(GetByUserId, new Object[]{userId}, new BeanPropertyRowMapper<>(CompanyProfile.class));
    }

    public void update(CompanyProfile cp) {
        jdbc.update(Update, cp.getName(), cp.getIndustry(), cp.getWebsite(), cp.getContactPerson(), cp.getLocation(), cp.getPhoneNo(), cp.getUserId());
    }
}
