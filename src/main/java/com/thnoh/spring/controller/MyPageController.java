package com.thnoh.spring.controller;

import com.thnoh.spring.model.User;
import com.thnoh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
