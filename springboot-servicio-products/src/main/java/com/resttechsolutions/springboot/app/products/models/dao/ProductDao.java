package com.resttechsolutions.springboot.app.products.models.dao;

import com.resttechsolutions.springboot.app.products.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Long> {
}
