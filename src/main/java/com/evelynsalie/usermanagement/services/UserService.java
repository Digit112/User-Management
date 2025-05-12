package com.evelynsalie.usermanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import java.sql.SQLException;

import com.evelynsalie.usermanagement.entities.User;

@Service
public class UserService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	private static class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(
				rs.getLong("id"),
				rs.getString("first_name"),
				rs.getString("last_name")
			);
		}
	}
	
	private static class UserResultSetExtractor implements ResultSetExtractor<User> {
		@Override
		public User extractData(ResultSet rs) throws SQLException {
			return new User(
				rs.getLong("id"),
				rs.getString("first_name"),
				rs.getString("last_name")
			);
		}
	}

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT id, first_name, last_name FROM users", new UserRowMapper());
    }

    public User getUserById(Long id) {
        return jdbcTemplate.query("SELECT id, first_name, last_name FROM users WHERE id = ?", new UserResultSetExtractor());
    }

    public void createUser(String first_name, String last_name) {
        jdbcTemplate.update("INSERT INTO users (first_name, last_name) VALUES (?, ?)", first_name, last_name);
    }
}