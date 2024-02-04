package com.gcu.business;

import java.util.List;

import com.gcu.models.ProductModel;

public interface ProductsBusinessServiceInterface {
    public void test();
	public void init();
	public void destroy();
    public List<ProductModel> getProducts();
    public ProductModel getById(int id);
    public List<ProductModel> searchProducts(String searchTerm);
    public long addOne(ProductModel newProduct);
    public boolean deleteOne(long id);
    public ProductModel updateOne(long idToUpdate, ProductModel updateProduct);
}
