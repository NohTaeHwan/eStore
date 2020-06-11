package com.thnoh.spring.service;

import com.thnoh.spring.dao.ProductDao;
import com.thnoh.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * Class : ProductService
 * Service Layer
 *
 * @Autowired : ProductDao
 */

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    public List<Product> getProducts(){
        return productDao.getProducts();
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }

    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }
}
