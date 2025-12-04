package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 断言方法示例 - 学习版
 *
 * 只演示最常用的7种断言
 *
 * @author Tenerife
 * @date 2025-11-17
 */
@DisplayName("断言方法示例")
public class AssertExample {

    /**
     * assertNull - 断言为null
     * 用途：检查结果是否为null（查询不存在的数据）
     */
    @Test
    @DisplayName("1. assertNull - 断言为null")
    public void testAssertNull() {
        String result = null;

        // 断言：result应该是null
        assertNull(result, "结果应该为null");
        System.out.println("✅ 通过：result 是 null");
    }

    /**
     * assertNotNull - 断言不为null
     * 用途：检查结果是否有值（计算年龄应该有结果）
     */
    @Test
    @DisplayName("2. assertNotNull - 断言不为null")
    public void testAssertNotNull() {
        String result = "有值";

        // 断言：result不应该是null
        assertNotNull(result, "结果应该有值");
        System.out.println("✅ 通过：result 有值 = " + result);
    }

    /**
     * assertTrue - 断言为真
     * 用途：检查条件是否成立（年龄 >= 18）
     */
    @Test
    @DisplayName("3. assertTrue - 断言为真")
    public void testAssertTrue() {
        int age = 25;

        // 断言：age应该 >= 18
        assertTrue(age >= 18, "年龄应该 >= 18");
        System.out.println("✅ 通过：age = " + age + " 条件成立");
    }

    /**
     * assertFalse - 断言为假
     * 用途：检查条件是否不成立（年龄 < 18）
     */
    @Test
    @DisplayName("4. assertFalse - 断言为假")
    public void testAssertFalse() {
        int age = 15;

        // 断言：age不应该 >= 18
        assertFalse(age >= 18, "年龄应该 < 18");
        System.out.println("✅ 通过：age = " + age + " 条件不成立");
    }

    /**
     * assertEquals - 断言相等
     * 用途：检查两个值是否相等（用户名、ID等）
     */
    @Test
    @DisplayName("5. assertEquals - 断言相等")
    public void testAssertEquals() {
        // 数字比较
        int result = 2 + 3;
        assertEquals(5, result, "2+3应该等于5");
        System.out.println("✅ 通过：" + result + " == 5");

        // 字符串比较
        String name = "张三";
        assertEquals("张三", name, "名字应该相等");
        System.out.println("✅ 通过：" + name + " == '张三'");
    }

    /**
     * assertThrows - 断言抛出异常
     * 用途：检查方法是否抛出预期的异常（参数非法）
     */
    @Test
    @DisplayName("6. assertThrows - 断言抛出异常")
    public void testAssertThrows() {
        // 检查是否抛出异常
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    if (true) {
                        throw new IllegalArgumentException("参数不合法");
                    }
                },
                "应该抛出IllegalArgumentException"
        );
        System.out.println("通过：捕获到了期望的异常");

        // 进一步检查异常消息
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> { throw new IllegalArgumentException("用户名为null"); }
        );
        assertEquals("用户名为null", ex.getMessage());
        System.out.println("通过：异常消息正确");
    }

    /**
     * assertAll - 组合断言
     * 用途：一次性检查多个条件，所有断言都会执行
     *
     * 对比普通断言：第一个失败后面就停止了
     * assertAll：全部执行，最后统一报告结果
     */
    @Test
    @DisplayName("7. assertAll - 组合断言")
    public void testAssertAll() {
        String name = "张三";
        int age = 25;
        String status = "正常";

        // 所有断言都会执行，即使某个失败
        assertAll("验证用户信息",
                () -> assertNotNull(name),
                () -> assertEquals("张三", name),
                () -> assertTrue(age >= 18),
                () -> assertEquals("正常", status)
        );
        System.out.println("通过：所有条件都验证成功");
    }
}