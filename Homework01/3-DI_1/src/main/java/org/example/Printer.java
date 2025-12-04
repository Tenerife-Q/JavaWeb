package org.example;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 打印机 - 使用构造器注入（最优方案）
 * 这是最简洁、最优、最易于理解的依赖注入方式！
 */
@Component  // ✅ 注解：告诉 Spring 我是一个 Bean
public class Printer {

    // ✅ 使用 final，表示这些依赖不可改变
    private final Paper paper;
    private final Ink ink;

    /**
     * ✅ 构造方法注入
     * Paper：使用 @Primary（A4Paper 已经标记为 Primary）
     * Ink：使用 @Qualifier 明确指定用 greyInk
     */
    public Printer(
            Paper paper,                            // ✅ Paper 用 @Primary 自动选择 A4Paper
            @Qualifier("greyInk") Ink ink           // ✅ Ink 明确指定用 greyInk
    ) {
        this.paper = paper;
        this.ink = ink;

        System.out.println("✅ Printer 初始化成功");
        System.out.println("   - 纸张：" + paper.getClass().getSimpleName());
        System.out.println("   - 墨盒：" + ink.getClass().getSimpleName());
    }

    /**
     * 打印方法
     */
    public void print(String str) {
        // ✅ 解决问题1：不再硬编码依赖
        // 使用注入的 paper 和 ink

        // ✅ 解决问题2：不再硬编码数据
        // 颜色值已经在墨盒类中定义
        System.out.print(ink.getColor());

        // 逐字符输出
        for (int i = 0; i < str.length(); ++i) {
            // ✅ 解决问题3：不需要类型检查
            // 直接调用接口方法，让对象自己处理
            paper.putInChar(str.charAt(i), i + 1);
        }

        // 输出纸张内容
        System.out.print(paper.getContent());
    }
}