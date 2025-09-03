/*

package com.Project.Inventory.and.Sales.Management.System.Service;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service

public class UserService implements UserDetailsService {

    private final JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return jdbcTemplate.queryForObject(
                "SELECT username, password, enabled FROM customer WHERE username = ?",
                new Object[]{username},
                (rs, rowNum) -> new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBoolean("enabled"),
                        true,
                        true,
                        true,
                        getAuthorities(username)
                )
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String username) {
        return jdbcTemplate.query(
                "SELECT authority FROM authorities WHERE username = ?",
                new Object[]{username},
                (rs, rowNum) -> new SimpleGrantedAuthority(rs.getString("authority"))
        );
    }
}


*/
