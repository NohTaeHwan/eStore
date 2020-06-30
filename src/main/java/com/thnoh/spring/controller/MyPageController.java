package com.thnoh.spring.controller;

import com.thnoh.spring.model.User;
import com.thnoh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyPageController {

    @Autowired
    private UserService userService;

    private String getPresentUser(){

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();


        return username;
    }

    @RequestMapping(value = "/mypage")
    public String getMyPage(){

        return "myPage";

    }

    @RequestMapping(value = "/deleteAccount")
    public String deleteAccount(Model model){

        User user = userService.getUserByUsername(getPresentUser());

        model.addAttribute("user",user);

        return "deleteAccount";
    }

    @RequestMapping(value = "/profile")
    public String updateProfile(Model model){

        User user = userService.getUserByUsername(getPresentUser());

        model.addAttribute("user",user);

        return "profile";
    }

    @RequestMapping(value="/updateAccount",method = RequestMethod.PUT)
    public String updateAccount(@Valid User user, BindingResult bindingResult){

        //기존 모델에 있던 정보들을 다시 setting
        user.setUsername(getPresentUser());
        user.setPassword(userService.getUserByUsername(getPresentUser()).getPassword());
        user.setCart(userService.getUserByUsername(getPresentUser()).getCart());
        user.setEnabled(userService.getUserByUsername(getPresentUser()).isEnabled());
        user.setAuthority(userService.getUserByUsername(getPresentUser()).getAuthority());

        //TODO error handler 구성하기
        if(bindingResult.hasErrors()&&user.getPassword()==null){
            System.out.println("update User error");

            List<ObjectError> errors = bindingResult.getAllErrors();

            for(ObjectError objectError:errors){
                System.out.println(objectError.getDefaultMessage());
            }

            return "redirect:/mypage?pageContent=profile&isRedirect=false";
        }

        userService.updateUser(user);

        return "redirect:/mypage?pageContent=profile&isRedirect=true";

    }


}
