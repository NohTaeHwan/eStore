package com.thnoh.spring.controller;

import com.thnoh.spring.model.Cart;
import com.thnoh.spring.model.CartItem;
import com.thnoh.spring.model.Product;
import com.thnoh.spring.model.User;
import com.thnoh.spring.service.CartItemService;
import com.thnoh.spring.service.CartService;
import com.thnoh.spring.service.ProductService;
import com.thnoh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * class : CartRestController
 *
 * 장바구니 CRUD 처리 controller
 *
 */
@RestController
@RequestMapping("/api/cart")
public class CartRestController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    //현재 로그인한 username을 가져옴.
    public String getPresentUser(){

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();


        return username;
    }


    @RequestMapping(value = "/{cartId}" , method = RequestMethod.GET)
    public ResponseEntity<Cart> getCartById (@PathVariable(value = "cartId") int cartId){
        Cart cart = cartService.getCartById(cartId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @RequestMapping(value = "/{cartId}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> clearCart(@PathVariable(value = "cartId") int cartId){
        Cart cart = cartService.getCartById(cartId);

        cartItemService.removeAllCartItems(cart);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "/add/{productId}",method = RequestMethod.PUT)
    public ResponseEntity<Void> addItem(@PathVariable(value = "productId") int productId){

        Product product = productService.getProductById(productId);

        User user = userService.getUserByUsername(getPresentUser());
        Cart cart = user.getCart();

        //아이템이 카트에 존재하는지 확인하고 존재하면 갯수만 추가
        List<CartItem> cartItems = cart.getCartItems();

        for(CartItem item:cartItems){

            if(product.getId() == item.getProduct().getId()){

                item.setQuantity(item.getQuantity()+1);
                item.setTotalPrice(product.getPrice() * item.getQuantity());
                cartItemService.addCartItem(item);

                return new ResponseEntity<>(HttpStatus.OK);

            }

        }

        //새로운 아이템 추가
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
        cartItem.setProduct(product);
        cartItem.setCart(cart);

        //bidirectional
        cart.getCartItems().add(cartItem);

        cartItemService.addCartItem(cartItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/cartitem/{productId}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> removeItem (@PathVariable(value = "productId") int productId){

        User user = userService.getUserByUsername(getPresentUser());
        Cart cart = user.getCart();

        CartItem cartItem = cartItemService.getCartItemByProductId(cart.getId(),productId);
        cartItemService.removeCartItem(cartItem);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
