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

/*
 ==============================================================================
                          【期末考试核心注解速记手册】
                       (直接背诵以下内容，涵盖选择/填空/代码题)
 ==============================================================================

 1. 启动类注解
 ------------------------------------------------------------------------------
 @SpringBootApplication
    - 作用：Spring Boot 的核心注解，标识这是启动类。
    - 考点：它是一个组合注解，本质上等于以下三个注解：
      1) @SpringBootConfiguration (配置类)
      2) @EnableAutoConfiguration (开启自动配置，如自动配好 Tomcat)
      3) @ComponentScan (自动扫描当前包及子包下的 Bean)

 2. 控制器注解 (类级别)
 ------------------------------------------------------------------------------
 @Controller
    - 作用：标识该类为 Spring MVC 控制器。
    - 行为：方法返回的字符串（如 "userinfo"）会被解析为视图页面（userinfo.html）。

 @RestController
    - 作用：标识该类为 RESTful 控制器。
    - 考点：@RestController = @Controller + @ResponseBody
    - 行为：所有方法返回的数据都会直接变成 JSON，不会跳转页面。

 3. 请求映射注解 (方法级别)
 ------------------------------------------------------------------------------
 @RequestMapping("/path")
    - 作用：映射请求路径。可用于类（统一前缀）或方法上。

 @GetMapping("/path")
    - 作用：只处理 HTTP GET 请求（查询）。等价于 @RequestMapping(method = RequestMethod.GET)。

 @PostMapping("/path")
    - 作用：只处理 HTTP POST 请求（提交表单）。等价于 @RequestMapping(method = RequestMethod.POST)。

 4. 参数接收注解 (参数级别) —— 最容易混淆！
 ------------------------------------------------------------------------------
 @RequestParam("name")
    - 场景：接收 URL 参数 (?name=zs) 或 表单单个字段。
    - 示例：public String list(@RequestParam("age") Integer age)

 @ModelAttribute (或不写直接跟对象)
    - 场景：接收表单提交的【多个字段】，自动封装成 Java 对象。
    - 示例：public String regist(User user) -> 前端 uname, uage 自动填入 user 对象。

 @RequestBody (本次实验未用，但 PPT 重点)
    - 场景：接收前端发来的 【JSON 格式】数据（非表单）。
    - 示例：public String add(@RequestBody User user)

 5. 响应处理注解
 ------------------------------------------------------------------------------
 @ResponseBody
    - 作用：告诉 Spring 不要去解析视图（不找 HTML）。
    - 行为：直接将返回值（List/Object）序列化为 JSON 写入响应体。
    - 场景：写 API 接口时必用。

 6. 核心对象
 ------------------------------------------------------------------------------
 Model model
    - 作用：后端和前端页面的“搬运工”。
    - 用法：model.addAttribute("key", value); -> 前端用 ${key} 取值。
 */