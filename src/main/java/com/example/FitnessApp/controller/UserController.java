package com.example.FitnessApp.controller;

import com.example.FitnessApp.dao.UserDao;
import com.example.FitnessApp.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private UserDao dao;

    public UserController(UserDao dao) {
        this.dao = dao;
    }


    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<User> viewAllUsers (){
        return dao.findAll();
    }

}
