package com.web.day.springweb.controller;

import com.web.day.springweb.model.User;
import com.web.day.springweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable String id) {
        System.out.println("...GetUser  " + id);
        return userService.Sel(id).toString();
    }

    @RequestMapping("work")
    public String work() {
        System.out.println("...work  ");
        return "test work";

    }

    @RequestMapping("update/{id}/{name}/{email}")
    public String updateUser(@PathVariable String id, @PathVariable String name, @PathVariable String email) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        userService.updateUser(user);
        return  " - updateUser - " + id;

    }
}
