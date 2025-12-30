package org.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring 配置类 - 替代 applicationContext.xml
 *
 * 这个类相当于原来的 applicationContext.xml
 * 所有配置都通过注解自动完成
 */
@Configuration  // ✅ 标记这是一个配置类
@ComponentScan("org.example")  // ✅ 自动扫描 org.example 包下所有 @Component
public class AppConfig {
    // 配置类通常是空的
    // 所有配置都通过注解自动完成
}