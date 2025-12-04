package com;

import com.entity.User;
import com.service.UserService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UserService 单元测试
 *
 * @author Tenerife
 * @date 2025-11-17 13:49
 */
@DisplayName("UserService单元测试")
public class UserServiceTest {

    private UserService userService;

    @BeforeAll
    public static void initAll() {
        System.out.println("========== 开始测试 ==========");
    }

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @AfterEach
    public void tearDown() {
        userService = null;
    }

    @AfterAll
    public static void cleanupAll() {
        System.out.println("========== 测试完成 ==========");
    }

    // ==================== getAge() 测试 ====================

    @Test
    @DisplayName("getAge-正常输入-2000年出生")
    public void testGetAge_Normal() {
        // 正确的身份证号
        Integer age = userService.getAge("110000200010011234");

        assertNotNull(age);
        assertTrue(age >= 24 && age <= 25);
    }

    @Test
    @DisplayName("getAge-null输入")
    public void testGetAge_Null() {
        assertNull(userService.getAge(null));
    }

    @Test
    @DisplayName("getAge-长度错误")
    public void testGetAge_WrongLength() {
        assertNull(userService.getAge("12345"));  // 太短
    }

    @Test
    @DisplayName("getAge-非法字符")
    public void testGetAge_InvalidChar() {
        // 包含字母，parseInt会抛异常，catch后返回null
        assertNull(userService.getAge("11000020001001ABCD"));
    }

    @Test
    @DisplayName("getAge-非法日期")
    public void testGetAge_InvalidDate() {
        // 2月30日，LocalDate.of会抛异常，catch后返回null
        assertNull(userService.getAge("110000200002301234"));
    }

    // ==================== isAdult() 测试 ====================

    @Test
    @DisplayName("isAdult-成年人")
    public void testIsAdult_Adult() {
        assertTrue(userService.isAdult("110000200001011234"));
    }

    @Test
    @DisplayName("isAdult-未成年")
    public void testIsAdult_Minor() {
        assertFalse(userService.isAdult("110000201001011234"));
    }

    @Test
    @DisplayName("isAdult-非法输入")
    public void testIsAdult_Invalid() {
        assertFalse(userService.isAdult(null));
        assertFalse(userService.isAdult("invalid"));
    }

    // ==================== login() 测试 ====================

    @Test
    @DisplayName("login-成功")
    public void testLogin_Success() {
        assertTrue(userService.login("admin", "123456"));
    }

    @Test
    @DisplayName("login-失败")
    public void testLogin_Fail() {
        assertFalse(userService.login("admin", "wrong"));
    }

    @Test
    @DisplayName("login-参数null")
    public void testLogin_Null() {
        assertThrows(IllegalArgumentException.class,
                () -> userService.login(null, "123456"));
    }

    @Test
    @DisplayName("login-参数为空")
    public void testLogin_Empty() {
        assertThrows(IllegalArgumentException.class,
                () -> userService.login("", "123456"));
    }

    @Test
    @DisplayName("login-长度不合法")
    public void testLogin_InvalidLength() {
        assertThrows(IllegalArgumentException.class,
                () -> userService.login("ab", "123456"));
    }

    // ==================== getUser() 测试 ====================

    @Test
    @DisplayName("getUser-正常查询")
    public void testGetUser_Normal() {
        User user = userService.getUser(1L);

        assertAll("验证用户信息",
                () -> assertNotNull(user),
                () -> assertEquals(1L, user.getId()),
                () -> assertEquals("张三", user.getName())
        );
    }

    @Test
    @DisplayName("getUser-边界条件")
    public void testGetUser_Boundary() {
        assertNull(userService.getUser(null));
        assertNull(userService.getUser(0L));
        assertNull(userService.getUser(-1L));
    }

    // ==================== updateUserStatus() 测试 ====================

    @Test
    @DisplayName("updateUserStatus-成功")
    public void testUpdateStatus_Success() {
        assertTrue(userService.updateUserStatus(1L, 0));
    }

    @Test
    @DisplayName("updateUserStatus-参数null")
    public void testUpdateStatus_Null() {
        assertThrows(IllegalArgumentException.class,
                () -> userService.updateUserStatus(null, 1));
    }

    @Test
    @DisplayName("updateUserStatus-状态值非法")
    public void testUpdateStatus_InvalidStatus() {
        assertThrows(IllegalArgumentException.class,
                () -> userService.updateUserStatus(1L, -1));
    }
}