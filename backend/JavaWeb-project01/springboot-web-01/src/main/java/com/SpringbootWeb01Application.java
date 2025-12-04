package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 作用
 *         ↓ 包含三个注解
 *         ├─ @SpringBootConfiguration
 *         │   └─ 声明这是一个Spring Boot配置类
 *         │
 *         ├─ @EnableAutoConfiguration
 *         │   └─ 启用自动配置（自动配置Spring容器）
 *         │
 *         └─ @ComponentScan
 *             └─ 组件扫描
 *                 ├─ 扫描当前包：com
 *                 ├─ 扫描子包：com.controller, com.service, com.dao 等
 *                 └─ 找到所有 @Component、@Service、@Repository、@Controller 等注解
 *                    ↓
 *                    将这些类交给 IoC 容器管理
 *
 *
 *
 *
 *   启动流程
 *   main() 启动
 *    ↓
 * SpringApplication.run()
 *    ↓
 * IoC 容器初始化
 *    ├─ 第1步：扫描 @ComponentScan 范围内的所有类
 *    ├─ 第2步：找到标有 @Component 等注解的类
 *    │   ├─ UserDaoImpl (@Repository)
 *    │   ├─ UserServiceImpl (@Service)
 *    │   ├─ UserServiceImpl2 (@Service)
 *    │   └─ UserController (@RestController)
 *    │
 *    ├─ 第3步：实例化 Bean（单例模式）
 *    │   ├─ userDao = new UserDaoImpl()
 *    │   ├─ userServiceImpl = new UserServiceImpl()
 *    │   ├─ userServiceImpl2 = new UserServiceImpl2()
 *    │   └─ userController = new UserController(?)
 *    │
 *    ├─ 第4步：依赖注入（DI）
 *    │   ├─ userServiceImpl.userDao = userDao
 *    │   ├─ userServiceImpl2.userDao = userDao
 *    │   └─ userController.userService = ?
 *    │       （需要选择 userServiceImpl 还是 userServiceImpl2）
 *    │
 *    └─ 第5步：应用就绪，等待请求
 */

@SpringBootApplication//包含@Component 默认扫描启动类所在当前包及其子包
public class SpringbootWeb01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWeb01Application.class, args);
    }

}
