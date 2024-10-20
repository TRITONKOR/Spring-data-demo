package org.example.springdatademo.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseCleanupConfig {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void cleanDatabase() {
        jdbcTemplate.execute("TRUNCATE TABLE product RESTART IDENTITY CASCADE");
        jdbcTemplate.execute("TRUNCATE TABLE category RESTART IDENTITY CASCADE");
    }
}
