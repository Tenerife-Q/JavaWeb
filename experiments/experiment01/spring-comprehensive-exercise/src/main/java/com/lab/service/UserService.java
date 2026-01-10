package com.lab.service;

/**
 * @author Tenerife
 * Su san
 * @date 2026/1/10 22:08
 */

import com.lab.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource; // 如报错请换 javax.annotation.Resource

@Service // 标记为业务层组件
public class UserService {

    private final UserDao userDao;

    // 考点：构造器注入 (Spring 4.3+ 只有唯一构造器时 @Autowired 可省略，但建议写上)
    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    // 考点：注入容器中配置的额外 Bean (@Resource 默认按名称)
    @Resource(name = "startupDate")
    private java.util.Date startTime;

    // 业务方法 1：正常流程
    public String processUser(String name) {
        System.out.println(">> [Service] Processing user: " + name);
        System.out.println(">> [Service] System started at: " + startTime);

        // 模拟耗时操作 (用于测试 AOP 耗时统计)
        try { Thread.sleep(500); } catch (InterruptedException e) {}

        return userDao.saveToDb(name);
    }

    // 业务方法 2：异常流程 (用于测试 @AfterThrowing)
    public void riskyAction() {
        System.out.println(">> [Service] Executing risky action...");
        throw new RuntimeException("Something went wrong!");
    }
}
