package com.springmvcexp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class SpringMvcExp2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcExp2Application.class, args);
    }

}

/**
 * @SpringBootApplication
 *  实际上是一个组合注解
 *  其中包含 ：
 *      1. @SpringBootConfiguration(配置类)
 *      2. @EnableAutoConfiguration(开启自动配置)
 *      3. @ComponentScan(自动扫描包)
 */

/*
    什么是“约定优于配置”？

    结合代码理解：你发现代码里没有配置 Tomcat，也没有配置 Spring MVC 的 XML 文件，但项目能直接跑，这就是“约定”。
    背诵话术：核心思想是框架预先定义一套默认规则（约定）。开发者遵循约定时几乎不需要配置，只有打破约定时才需要显式配置 。

    例子：
    Spring Boot 默认约定使用 Tomcat 作为内置容器 。
*/
