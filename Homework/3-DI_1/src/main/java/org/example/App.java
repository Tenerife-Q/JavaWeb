//package org.example;
//
///**
// * Hello world!
// *
// */
//public class App
//{
//    public static void main( String[] args )
//    {
//
//        Printer printer = new Printer();
//        printer.print("三月七日，沙湖道中遇雨。雨具先去，同行皆狼狈，余独不觉。已而遂晴，故作此词。" +
//                "莫听穿林打叶声，何妨吟啸且徐行。"+
//                "竹杖芒鞋轻胜马，谁怕？一蓑烟雨任平生。" +
//                "料峭春风吹酒醒，微冷，山头斜照却相迎。" +
//                "回首向来萧瑟处，归去，也无风雨也无晴。");
//    }
//}

package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 主程序 - 使用注解方式 + 构造器注入
 */
public class App {
    public static void main(String[] args) {

        System.out.println("========== Spring DI 项目启动 ==========\n");

        // ✅ 初始化 Spring 容器（注解方式）
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("\n========== Spring 容器初始化完成 ==========\n");

        // ✅ 从容器中获取 Printer Bean
        Printer printer = context.getBean(Printer.class);

        System.out.println("\n========== 开始打印 ==========\n");

        // ✅ 使用打印机
        printer.print("三月七日，沙湖道中遇雨。雨具先去，同行皆狼狈，余独不觉。已而遂晴，故作此词。" +
                "莫听穿林打叶声，何妨吟啸且徐行。" +
                "竹杖芒鞋轻胜马，谁怕？一蓑烟雨任平生。" +
                "料峭春风吹酒醒，微冷，山头斜照却相迎。" +
                "回首向来萧瑟处，归去，也无风雨也无晴。");

        System.out.println("\n========== 打印完成 ==========");
    }
}