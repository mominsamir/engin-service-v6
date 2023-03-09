package com.engin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.sql.DataSource;

@Configuration
public class WebConfig  {
    @Autowired
    Environment env;
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(env.getProperty("DB_JDBC_URL"));
        dataSource.setUrl(env.getProperty("DB_USER_NAME"));
        dataSource.setUrl(env.getProperty("DB_USER_PASSWORD"));
        return dataSource;
    }
}
