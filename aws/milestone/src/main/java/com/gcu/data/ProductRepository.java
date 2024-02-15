package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.gcu.models.ProductEntity;
import com.gcu.models.ProductModel;

public class ProductRepository implements ProductDataAccessInterface<ProductModel>{

    ProductRepositoryInterface productRepository = (ProductRepositoryInterface) new ProductRepository();

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ProductModel getByID(long id) {
        ProductEntity entity = productRepository.findById(id).orElse(null);
        ProductModel model = modelMapper.map(entity, ProductModel.class);
        return model;
    }

    @Override
    public List<ProductModel> getProducts() {
        Iterable<ProductEntity> productEntity = productRepository.findAll();
        List<ProductModel> models = new ArrayList<ProductModel>();

        for (ProductEntity item : productEntity){
            models.add(modelMapper.map(item, ProductModel.class));
        }

        return models;
    }

    @Override
    public List<ProductModel> searchProducts(String searchTerm) {
        Iterable<ProductEntity> entities = productRepository.findByProductNameContainingIgnoreCase(searchTerm);
        List<ProductModel> orders = new ArrayList<ProductModel>();

        for(ProductEntity entity : entities){
            orders.add(modelMapper.map(entity, ProductModel.class));
        }

        return orders;
    }

    @Override
    public long addOne(ProductModel newProduct) {
        ProductEntity entity = modelMapper.map(newProduct, ProductEntity.class);
        ProductEntity result = productRepository.save(entity);
        if (result == null){
            return 0;
        }
        else{
            return result.getId();
        }
    }

    @Override
    public boolean deleteOne(long iD) {
        productRepository.deleteById(iD);
        return true;
    }

    @Override
    public ProductModel updateOne(long idToUpdate, ProductModel updateProduct) {
        ProductEntity entity = modelMapper.map(updateProduct, ProductEntity.class);
        ProductEntity result = productRepository.save(entity);
        ProductModel model = modelMapper.map(result, ProductModel.class);

        return model;
    }
    
}
