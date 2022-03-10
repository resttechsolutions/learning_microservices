package com.resttechsolutions.springboot.app.products.models.service;

import com.resttechsolutions.springboot.app.products.models.dao.ProductDao;
import com.resttechsolutions.springboot.app.products.models.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductoServiceImpl implements IProductService{

    @Autowired
    private ProductDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return dao.findById(id).orElse(null);
    }
}
