package com.lab.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        // 加载配置文件，生成 ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 从 IOC 容器中获取 Bean
        User male = (User) context.getBean("maleUser");

        // 调用方法进行输出
        System.out.println("--- Testing IOC ---");
        male.pay();
        male.receive();
    }
}