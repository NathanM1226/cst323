package com.gcu.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.models.LoginModel;

public class RegistrationDataService implements RegistrationDataInterface{

    @Autowired
    DataSource dataSource;

    @Autowired 
    JdbcTemplate jdbcTemplate;

    public RegistrationDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean isAuthenticated(LoginModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAuthenticated'");
    }

    @Override
    public boolean isTaken(LoginModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isTaken'");
    }

    @Override
    public int addOne(LoginModel newUser) {
        return jdbcTemplate.update(
            "INSERT INTO users(USERNAME, PASSWORD) VALUES (?,?)",
            newUser.getUsername(),
            newUser.getPassword()
        );
                
    }
    
}
