package com.thnoh.spring.dao;

import com.thnoh.spring.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * class : ProductDao
 *
 * DB : mysql
 * ORM : Hibernate 5
 *
 */

@Repository
@Transactional
public class ProductDao {

    @Autowired
    private SessionFactory sessionFactory;


    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class,id);

        return product;
    }

    @SuppressWarnings("unchecked")
    public List<Product> getProducts() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> productList = query.list();

        return productList;

    }

    public void addProduct(Product product) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();

    }

    public void deleteProduct(Product product) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }


    public void updateProduct(Product product) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }
}
