package com.thnoh.spring.controller;

import com.thnoh.spring.model.User;
import com.thnoh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * class : UserAdminController
 *
 * User 관리 페이지 View 처리 controller
 *
 */

@Controller
@RequestMapping("/admin/userAdmin")
public class UserAdminController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String getUsers(Model model){

        List<User> users = userService.getAllUsers();

        //유저 목록에서 admin 권한을 가진 아이디는 배제
        for(User user : users){
            if(user.getAuthority().equals("ROLE_ADMIN")){
                users.remove(user);
            }
        }

        model.addAttribute("users",users);

        return "userAdmin";
    }

}
