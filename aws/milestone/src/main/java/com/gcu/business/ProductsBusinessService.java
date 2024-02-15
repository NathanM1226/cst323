package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ProductDataAccessInterface;
import com.gcu.models.ProductModel;

public class ProductsBusinessService implements ProductsBusinessServiceInterface {

    @Autowired
    ProductDataAccessInterface<ProductModel> productsDAO;

    @Override
    public List<ProductModel> getProducts() {
        List<ProductModel> results = productsDAO.getProducts();
        return results;
    }

    @Override
    public ProductModel getById(int id) {
        return productsDAO.getByID(id);
    }

    @Override
    public List<ProductModel> searchProducts(String searchTerm) {
        return productsDAO.searchProducts(searchTerm);
    }

    @Override
    public long addOne(ProductModel newProduct) {
        return productsDAO.addOne(newProduct);
    }

    @Override
    public boolean deleteOne(long id) {
        return productsDAO.deleteOne(id);
    }

    @Override
    public ProductModel updateOne(long idToUpdate, ProductModel updateProduct) {
        return productsDAO.updateOne(idToUpdate, updateProduct);
    }

    @Override
    public void test() {
        System.out.println("The test method of the OrdersBusinessService appears to be working if you can see this text");

    }

    @Override
    public void init() {
        System.out.println("Init method of OrdersBusinessService was just called.");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method of OrdersBusinessService was just called.");
    }
    
}
