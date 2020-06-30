package com.thnoh.spring.controller;

import com.thnoh.spring.model.User;
import com.thnoh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/mypage")
public class MyPageRestController {

    @Autowired
    private UserService userService;

    private String getPresentUser(){

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();


        return username;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAccount(@RequestParam(value = "logout",required = false) String logout){

        User user = userService.getUserByUsername(getPresentUser());

        userService.deleteUser(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<User> getAccount(){

        User user = userService.getUserByUsername(getPresentUser());

        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    /*
    //TODO 항목 validation
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAccount(@RequestBody User user){

        System.out.println("혹시 여기까지는 오니???");

        userService.updateUser(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }*/





}
