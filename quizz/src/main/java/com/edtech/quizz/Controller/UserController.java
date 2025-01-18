package com.edtech.quizz.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edtech.quizz.Model.Users;
import com.edtech.quizz.Service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class UserController {

    @Autowired
    private UserService service;
    
    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return service.register(user);
    }

    @GetMapping("/getUsers")
    public List<Users> getUsers(){
        return service.getallUsers();
    }

}
/*
 * id
 * scoreH
 * lev
 * qset
 * Xp
 * name
 */