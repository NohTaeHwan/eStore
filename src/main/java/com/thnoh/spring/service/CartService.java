package com.thnoh.spring.service;

import com.thnoh.spring.dao.CartDao;
import com.thnoh.spring.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartDao cartDao;

    public Cart getCartById(int cartId){
        return cartDao.getCartById(cartId);
    }


}
