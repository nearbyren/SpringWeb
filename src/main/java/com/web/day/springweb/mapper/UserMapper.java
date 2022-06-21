package com.web.day.springweb.mapper;

import com.web.day.springweb.model.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserMapper {
    User Sel(String id);

    void updateUser(User user);
}
