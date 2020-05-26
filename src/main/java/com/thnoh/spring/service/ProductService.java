package com.thnoh.spring.service;

import com.thnoh.spring.dao.ProductDao;
import com.thnoh.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getProducts(){
        return productDao.getProducts();
    }
}
