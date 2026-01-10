package com.lab.controller;

/**
 * @author Tenerife
 * Su san
 * @date 2026/1/10 22:07
 */

import com.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller // 标记为 Web 控制层
@Scope("prototype") // 考点：多例模式 (每次获取都是新对象)
public class UserController {

    @Autowired // 考点：属性注入 (最简单，但不如构造器注入严谨)
    private UserService userService;

    public void handleRequest(String name) {
        System.out.println(">> [Controller] Request received for: " + name);
        userService.processUser(name);
    }

    public void triggerError() {
        userService.riskyAction();
    }
}
