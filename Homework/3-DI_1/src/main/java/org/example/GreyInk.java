//package org.example;
//
///**
// * @ClassName : GreyInk
// * @Description :
// * @Author : ZJ
// * @Date: 2025-11-10 21:00
// */
//public class GreyInk {
//    public int r;
//    public int g;
//    public int b;
//    public void setColor(int r, int g, int b){
//        this.r = r;
//        this.g = g;
//        this.b = b;
//    }
//    public String getColor() {
//        return "打印颜色是：rgb(" + r + "," + g + "," + b + ")\n\r";
//    }
//
//}

package org.example;

import org.springframework.stereotype.Component;

/**
 * 灰色墨盒实现
 */
@Component  // ✅ 注解：告诉 Spring 我是一个 Bean
public class GreyInk implements Ink {
    private int r;
    private int g;
    private int b;

    // ✅ 默认构造方法注入颜色值
    public GreyInk() {
        this.r = 128;
        this.g = 128;
        this.b = 128;
    }

    @Override
    public String getColor() {
        return "打印颜色是：灰色，rgb(" + r + "," + g + "," + b + ")\n\r";
    }
}