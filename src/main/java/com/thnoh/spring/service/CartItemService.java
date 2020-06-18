package com.thnoh.spring.service;

import com.thnoh.spring.dao.CartItemDao;
import com.thnoh.spring.model.Cart;
import com.thnoh.spring.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem){
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem){
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart){
        cartItemDao.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProductId (int cartId, int productId){
        return cartItemDao.getCartItemByProductId(cartId,productId);
    }

}
