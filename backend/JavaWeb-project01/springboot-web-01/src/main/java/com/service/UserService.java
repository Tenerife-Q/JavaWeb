package com.service;

import com.pojo.User;

import java.util.List;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/19 14:13
 */
public interface UserService {

    //查询所有用户信息
    public List<User> findAll();

}
