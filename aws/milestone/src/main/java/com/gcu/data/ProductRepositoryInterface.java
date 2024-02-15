package com.gcu.data;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.gcu.models.ProductEntity;

public interface ProductRepositoryInterface extends CrudRepository<ProductEntity, Long>{
    List<ProductEntity> findByProductNameContainingIgnoreCase(String searchTerm);
}
