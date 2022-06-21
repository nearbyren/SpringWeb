package com.web.day.springweb.service;

import com.web.day.springweb.mapper.UserMapper;
import com.web.day.springweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public User Sel(String id) {
        User user = userMapper.Sel(id);
        if (user == null) {
            System.out.println(" user null");
        }
        return user;
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }


}
