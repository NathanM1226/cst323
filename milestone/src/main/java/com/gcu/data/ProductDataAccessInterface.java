package com.gcu.data;

import java.util.List;

public interface ProductDataAccessInterface<T> {
    public T getByID(long id);
    public List<T> getProducts();
    public List<T> searchProducts(String searchTerm);
    public long addOne(T newProduct);
    public boolean deleteOne(long iD);
    public T updateOne(long idToUpdate, T updateProduct);
}
