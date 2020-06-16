package com.thnoh.spring.dao;

import com.thnoh.spring.model.Cart;
import com.thnoh.spring.model.CartItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CartItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(CartItem cartItem) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem(CartItem cartItem) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    public void removeAllCartItems(Cart cart) {

        List<CartItem> cartItems = cart.getCartItems(); //fetch를 eager로 줬기 때문에 따로 DB에서 cartItem을 가져오는 코드 필요 x

        for(CartItem item:cartItems){
            removeCartItem(item);
        }
    }

    @SuppressWarnings("unchecked")
    public CartItem getCartItemByProductId(int cartId, int productId) {

        Session session = sessionFactory.getCurrentSession();

        TypedQuery<CartItem> query = session.createQuery("from CartItem where cart.id=? and product.id = ?");
        query.setParameter(0,cartId);
        query.setParameter(1,productId);

        return query.getSingleResult();

    }
}
