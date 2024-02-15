package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.models.ProductMapper;

import com.gcu.models.ProductModel;


@DependsOnDatabaseInitialization
@Repository
public class ProductDataService implements ProductDataAccessInterface<ProductModel> {

    @Autowired
    DataSource dataSource;

    @Autowired 
    JdbcTemplate jdbcTemplate;

    public ProductDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ProductModel getByID(long id) {
        return jdbcTemplate.queryForObject("select * from PRODUCTS where Id = ?",
                new ProductMapper(),
                new Object[]{id});
    }

    @Override
    public List<ProductModel> getProducts() {

        List<ProductModel> results = jdbcTemplate.query("select * from products", new ProductMapper());
        return results;
    }

    @Override
    public List<ProductModel> searchProducts(String searchTerm) {
        return jdbcTemplate.query("select * from PRODUCTS where GADGET_NAME LIKE ?",
                new ProductMapper(),
                new Object[] { "%" + searchTerm + "%" });
    }

    @Override
    public long addOne(ProductModel newProduct) {
        return jdbcTemplate.update(
                "insert into PRODUCTS (GADGET_NAME, DATE_OF_ORIGIN, LETHALITY_RATING, PHOTO_FILE_NAME, INSTRUCTIONS, DESCRIPTION, PRICE) values (?,?,?,?,?,?,?)",
                newProduct.getGadgetName(),
                newProduct.getDateOfOrigin(),
                newProduct.getLethalityRating(),
                newProduct.getPhotoFileName(),
                newProduct.getInstructions(),
                newProduct.getDescription(),
                newProduct.getPrice());
    }

    @Override
    public boolean deleteOne(long id) {
        int updateResult = jdbcTemplate.update("delete from PRODUCTS where id = ?",
            new Object[]{id});
        return (updateResult > 0);
    }

    @Override
    public ProductModel updateOne(long idToUpdate, ProductModel updateProduct) {
        int result = jdbcTemplate.update(
            "update PRODUCTS set `GADGET_NAME` = ?, `DATE_OF_ORIGIN` = ?, `LETHALITY_RATING` = ?, `PHOTO_FILE_NAME` = ?, `INSTRUCTIONS` = ?, `DESCRIPTION` = ?, `PRICE` = ? where id = ?",
            updateProduct.getGadgetName(),
            updateProduct.getDateOfOrigin(),
            updateProduct.getLethalityRating(),
            updateProduct.getPhotoFileName(),
            updateProduct.getInstructions(),
            updateProduct.getDescription(),
            updateProduct.getPrice(),
            updateProduct.getId());

            if (result > 0)
            return updateProduct;
            else
            return null;
    }

}
