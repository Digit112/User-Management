package com.evelynsalie.usermanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Map<String, Object>> getAllUsers() {
        return jdbcTemplate.queryForList("SELECT * FROM users");
    }

    public Map<String, Object> getUserById(Long id) {
        return jdbcTemplate.queryForMap("SELECT * FROM users WHERE id = ?", id);
    }

    public void createUser(String first_name, String last_name) {
        jdbcTemplate.update("INSERT INTO users (first_name, last_name) VALUES (?, ?)", first_name, last_name);
    }
}