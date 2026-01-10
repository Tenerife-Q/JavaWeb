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