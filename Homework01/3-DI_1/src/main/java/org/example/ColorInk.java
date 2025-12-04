package org.example;

import org.springframework.stereotype.Component;

/**
 * 彩色墨盒实现
 */
@Component  // ✅ 注解：告诉 Spring 我是一个 Bean
public class ColorInk implements Ink {
    private int r;
    private int g;
    private int b;

    // ✅ 默认构造方法注入颜色值
    public ColorInk() {
        this.r = 255;
        this.g = 0;
        this.b = 0;
    }

    @Override
    public String getColor() {
        return "打印颜色是：彩色，rgb(" + r + "," + g + "," + b + ")\n\r";
    }
}