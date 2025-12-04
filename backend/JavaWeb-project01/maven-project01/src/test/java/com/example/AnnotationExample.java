package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit注解示例 - 学习版
 *
 * 只演示最常用的注解
 *
 * @author Tenerife
 * @date 2025-11-17
 */
@DisplayName("JUnit注解示例")
public class AnnotationExample {

    /**
     * @BeforeAll - 所有测试前执行一次
     *
     * 特点：必须是 static
     * 场景：初始化全局资源（数据库连接等）
     */
    @BeforeAll
    public static void initAll() {
        System.out.println("\n========== 开始测试 ==========");
        System.out.println("@BeforeAll: 所有测试前执行1次（全局初始化）");
    }

    /**
     * @BeforeEach - 每个测试前执行
     *
     * 特点：不需要 static
     * 场景：初始化测试环境、创建测试对象
     * 好处：保证每个测试独立，互不影响
     */
    @BeforeEach
    public void setUp() {
        System.out.println("\n>>> @BeforeEach: 准备测试环境");
        System.out.println("    创建对象、初始化数据...");
    }

    /**
     * @Test - 标记测试方法
     *
     * 这是真正的测试代码
     */
    @Test
    @DisplayName("测试1 - 基本功能")
    public void test1() {
        System.out.println("    执行 test1");
        assertEquals(10, 5 + 5);
    }

    /**
     * @DisplayName - 自定义测试名称
     *
     * 作用：在测试报告中显示中文描述
     * 不加 @DisplayName: 显示 test2()
     * 加 @DisplayName:   显示 "测试2 - 边界检查"
     */
    @Test
    @DisplayName("测试2 - 边界检查")
    public void test2() {
        System.out.println("    执行 test2");
        assertTrue(10 > 5);
    }

    /**
     * @Test 测试3
     */
    @Test
    @DisplayName("测试3 - 异常处理")
    public void test3() {
        System.out.println("    执行 test3");
        assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0;
        });
    }

    /**
     * @AfterEach - 每个测试后执行
     *
     * 特点：不需要 static
     * 场景：清理测试数据、释放资源
     */
    @AfterEach
    public void tearDown() {
        System.out.println("<<< @AfterEach: 清理测试环境");
    }

    /**
     * @AfterAll - 所有测试后执行一次
     *
     * 特点：必须是 static
     * 场景：关闭全局资源（关闭数据库等）
     */
    @AfterAll
    public static void cleanupAll() {
        System.out.println("\n========== 测试完成 ==========\n");
    }

    /**
     * @Disabled - 禁用此测试
     *
     * 作用：临时跳过某个测试
     * 场景：功能未完成、发现bug等
     */
    @Test
    @Disabled("功能未完成")
    @DisplayName("未实现的功能")
    public void testUnimplemented() {
        System.out.println("这个测试会被跳过");
        fail("不会执行");
    }

    /**
     * ==================== 执行流程 ====================
     *
     * @BeforeAll (1次)
     *     ↓
     * @BeforeEach → @Test(test1) → @AfterEach
     * @BeforeEach → @Test(test2) → @AfterEach
     * @BeforeEach → @Test(test3) → @AfterEach
     * @Disabled(跳过)
     *     ↓
     * @AfterAll (1次)
     */
}