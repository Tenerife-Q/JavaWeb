package com.service.impl;

import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/19 14:13
 */
//这是选择注入提高优先级方法1 优先会注入UserServiceImpl2
//@Primary  如果bean注入有多个实现类 就必须标注也有限实现的@Primary 不然会报错
@Service
public class UserServiceImpl2 implements UserService {
    @Autowired// 应用程序运行时，会自动查询该类型的bean对象 并赋值给该成员变量
    private UserDao userDao;

    @Override
    public List<User> findAll() {

        List<String> lines = userDao.findAll();

        //2.解析用户信息 封装为User对象 -> list集合
        List<User> userList = lines.stream().map( line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id  + 200, username, password, name, age, updateTime);
        }).collect(Collectors.toList());

        return userList;
    }
}
