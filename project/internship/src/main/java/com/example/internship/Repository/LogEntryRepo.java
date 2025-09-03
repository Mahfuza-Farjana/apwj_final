package com.example.internship.Repository;

import com.example.internship.Entity.LogEntry;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class LogEntryRepo {
    public JdbcTemplate jdbc;

    public String GetByUserId = "SELECT * FROM logentry WHERE userid=?";
    public String Insert = "INSERT INTO logentry (userid, method, action, timestamp) VALUES (?, ?, ?, ?)";

    public LogEntryRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<LogEntry> getByUserId(int userId) {
        return jdbc.query(GetByUserId, new Object[]{userId}, new BeanPropertyRowMapper<>(LogEntry.class));
    }

    public void insert(LogEntry log) {
        jdbc.update(Insert, log.getUserid(), log.getMethod(), log.getAction(), log.getTimeStamp());
    }
}

