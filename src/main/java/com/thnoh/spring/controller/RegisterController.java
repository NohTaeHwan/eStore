package com.thnoh.spring.controller;

import com.thnoh.spring.model.Cart;
import com.thnoh.spring.model.ShippingAddress;
import com.thnoh.spring.model.User;
import com.thnoh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String registerUser(Model model){

        User user = new User();
        ShippingAddress shippingAddress = new ShippingAddress();

        user.setShippingAddress(shippingAddress);

        model.addAttribute("user",user);

        return "registerUser";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerUserPost(@Valid User user, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "registerUser";
        }

        List<User> userList = userService.getAllUsers();

        //아이디 중복 체크
        for(User obj:userList){
            if(user.getUsername().equals(obj.getUsername())){
                model.addAttribute("usernameMsg","username already exist");
                return "registerUser";
            }
        }

        user.setEnabled(true);

        //권한 설정(admin , user)
        if(user.getUsername().equals("admin"))
            user.setAuthority("ROLE_ADMIN");
        else
            user.setAuthority("ROLE_USER");

        Cart cart = new Cart();
        user.setCart(cart);

        userService.addUser(user);

        return "registerUserSuccess";
    }

}
