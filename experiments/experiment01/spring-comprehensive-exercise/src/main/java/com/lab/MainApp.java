package com.lab;

import com.lab.config.AppConfig;
import com.lab.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // 使用 AnnotationConfigApplicationContext 启动，而不是 SpringApplication.run
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserController controller = context.getBean(UserController.class);
        controller.handleRequest("TestUser");
    }
}