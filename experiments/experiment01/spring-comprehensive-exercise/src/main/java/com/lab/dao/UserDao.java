package com.lab.dao;

/**
 * @author Tenerife
 * Su san
 * @date 2026/1/10 22:06
 */

import org.springframework.stereotype.Repository;

@Repository // 标记为 DAO 层组件
public class UserDao {
    public String saveToDb(String data) {
        System.out.println(">> [DAO] Saving data: " + data);
        return "SUCCESS-ID-" + System.currentTimeMillis();
    }
}

/**
 * 基本上是 Dao -> Service -> Controller
 * 互相注入依赖关系 就是将之前的组件逻辑添加到箭头后面调用他的组件中去
 */