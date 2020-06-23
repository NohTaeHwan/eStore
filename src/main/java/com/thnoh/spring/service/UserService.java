package com.thnoh.spring.service;

import com.thnoh.spring.dao.UserDao;
import com.thnoh.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * Class : UserService
 * Service Layer
 *
 * @Autowired : UserDao
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void addUser(User user){
        userDao.addUser(user);
    }

    public User getUserById(int userId){
        return userDao.getUserById(userId);
    }

    public User getUserByUsername(String username){
        return userDao.getUserByUsername(username);
    }

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public void deleteUser(User user) { userDao.deleteUser(user); }

    public void deleteAllUsers(){ userDao.deleteAllUsers(); }

}
