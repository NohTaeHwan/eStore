package com.thnoh.spring.dao;

import com.thnoh.spring.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Cart getCartById(int cartId){

        Session session = sessionFactory.getCurrentSession();
        return session.get(Cart.class,cartId);
    }

}
