package com.thnoh.spring.controller;


import com.thnoh.spring.model.User;
import com.thnoh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * class : CartController
 *
 * Cart의 view 처리 controller
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String getCart(Model model){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userService.getUserByUsername(username);
        int cartId = user.getCart().getId();

        model.addAttribute("cartId",cartId);

        return "cart";
    }

}
