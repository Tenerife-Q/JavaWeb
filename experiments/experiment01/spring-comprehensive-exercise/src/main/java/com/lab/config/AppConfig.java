package com.lab.config;

/**
 * @author Tenerife
 * Su san
 * @date 2026/1/10 22:06
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import java.util.Date;

@Configuration // 1. 标记为配置类
@ComponentScan("com.lab") // 2. 扫描所有组件 (@Component, @Service, etc.)
@EnableAspectJAutoProxy // 3. 开启 AOP 自动代理
public class AppConfig {

    // 4. 手动定义一个第三方 Bean (模拟 xml 中的 <bean>)
    @Bean
    public Date startupDate() {
        return new Date();
    }
}