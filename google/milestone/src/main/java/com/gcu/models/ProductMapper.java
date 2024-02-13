package com.gcu.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<ProductModel>{

    @Override
    public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductModel product = new ProductModel(
            rs.getLong("ID"),
            rs.getString("GADGET_NAME"),
            rs.getInt("DATE_OF_ORIGIN"),
            rs.getInt("LETHALITY_RATING"),
            rs.getString("PHOTO_FILE_NAME"),
            rs.getString("INSTRUCTIONS"),
            rs.getString("DESCRIPTION"),
            rs.getFloat("PRICE"));

            return product;
    }
    
}
