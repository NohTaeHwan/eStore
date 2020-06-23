package com.thnoh.spring.controller;

import com.thnoh.spring.model.User;
import com.thnoh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * class : UserRestController
 *
 * 유저 관리 페이지의 CRUD 처리
 *
 * getAllUsers()에서 admin을 제외시키는 로직 사용(불변 컬렉션)
 * -> ConcurrentModificationException 방지.
 *
 * TODO clear all user
 */

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers(){


        List<User> users = userService.getAllUsers();


        List<User> normalUsers = users.stream().filter(user->{
            if (user.getAuthority().equals("ROLE_ADMIN")) {
                return false;
            }
            return true;
        }).collect(Collectors.toList());



        return new ResponseEntity<>(normalUsers,HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "userId") int userId){

        User user = userService.getUserById(userId);

        userService.deleteUser(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAllUsers(){

        userService.deleteAllUsers();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
