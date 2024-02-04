package com.gcu.business;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.models.LoginModel;

public class AllValidLogins implements SecurityServiceInterface {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public AllValidLogins() {
        
    }

    String[][] validLogins = new String[][] {
            { "Darius", "pass" },
            { "Sarafia", "nothing" },
            { "Merlin", "ihavethepower" },
            { "Quinn", "secret" },
            { "Jillian", "password" },
            { "Fanta", "fizzy" }
    };

    @Override
    public boolean isAuthenticated(LoginModel loginModel) {

        boolean success = false;
        for (int i = 0; i < validLogins.length; i++) {
            if (loginModel.getUsername().equals(validLogins[i][0])
                    && loginModel.getPassword().equals(validLogins[i][1])) {
                success = true;
            }
        }

        if (success) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean isTaken(LoginModel loginModel) {
        boolean success = false;
        for (int i = 0; i < validLogins.length; i++) {
            if (loginModel.getUsername().equals(validLogins[i][0])) {
                success = true;
            }
        }

        if (success) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int addOne(LoginModel newUser) {
        return jdbcTemplate.update(
                "INSERT INTO users(USERNAME, PASSWORD) VALUES (?,?)",
                newUser.getUsername(),
                newUser.getPassword());
    }
}
