package com.cotroller;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * DI 三种注入方式流程
 *
 * 1. 属性注入
 * IoC 容器扫描发现 @Autowired
 *    ↓
 * 通过反射，查找 UserService 类型的 Bean
 *    ↓
 * 找到 UserServiceImpl（@Service 标记）
 *    ↓
 * 反射调用字段的 setter 方法（虽然没有明确的 setter）
 *    ↓
 * userService = userServiceImpl 实例
 *
 * 2. 构造器注入
 * IoC 容器创建 UserController 实例
 *    ↓
 * 发现 UserController 有构造函数
 *    ↓
 * 检查构造函数参数：需要 UserService
 *    ↓
 * 查找 @Qualifier("userServiceImpl") 指定的 Bean
 *    ↓
 * 找到 userServiceImpl 实例
 *    ↓
 * 调用 new UserController(userServiceImpl)
 *    ↓
 * this.userService = userServiceImpl（final，不可变）
 *
 *
 * 3. setter注入
 * IoC 容器创建 UserController 实例
 *    ↓
 * 扫描所有 setter 方法，寻找 @Autowired 注解
 *    ↓
 * 找到 setUserService() 方法
 *    ↓
 * 查找 UserService 类型的 Bean
 *    ↓
 * 调用 setUserService(userServiceImpl)
 *    ↓
 * this.userService = userServiceImpl
 */


@RestController//包含@Controller  声名控制层的bean只能使用@Controller
public class UserController {
    //方式一 属性注入
    //@Autowired
    //private UserService userService;

    //方法3 @Resource 选择bean注入
    //@Resource(name = "userServiceImpl")
    //private UserService userService;

    /**
     * @Resource 与 @Autowired 区别
     * @Autowired 是spring框架提供的注解  @Resource 是JavaEE规范提供
     * @Autowired 默认按照类型注入  @Resource 默认是按照名称注入
     */

    //方式二 构造器注入
    @Qualifier("userServiceImpl")//方法2默认是bean名字即实现类首字母小写 @Qualifier配合@Autowired 选择注入
    @Autowired//这里可以省略 当前类中只存在一个构造函数 @Autowired就可以省略
    private final UserService userService;

    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    //方式三 setter注入
    //private UserService userService;
    //@Autowired
    //public void setUserService(UserService userService) {
    //    this.userService = userService;
    //}

    @RequestMapping("/list")
    public List<User> list() throws Exception {
        List<User> userList = userService.findAll();

        return userList;
    }
}

/**
 * 下面是统一三个方法 耦合度较高 代码复用性差 且难以维护
 * 上面是三层架构中的控制层 接收Service层的数据
 * Controller负责接收请求 响应数据
 * Service 负责业务逻辑处理
 * Dao 负责数据访问操作 也就是数据增删改查工作
 */


//package com.cotroller;
//
//import cn.hutool.core.io.IoUtil;
//import com.pojo.User;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author Tenerife           // 作者名称
// * Su san                      // 协作者名称
// * @date 2025/11/18 16:34     // 创建日期和时间
// */
//
//import cn.hutool.core.io.IoUtil;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.stream.Collectors;
//
///**
// * @RestController
// * 作用：将此类标记为 REST 控制器
// * 效果：
// *   1. 自动将该类的所有方法返回值序列化为 JSON
// *   2. 相当于 @Controller + @ResponseBody 的组合
// *   3. 所有返回值直接作为响应体，不需要手动转换
// */
//@RestController
//public class UserController {
//
//    /**
//     * @RequestMapping("/list")
//     * 作用：映射 HTTP 请求到此方法
//     * 含义：
//     *   - 当前端发送请求到 /list 路径时，会调用此方法
//     *   - 前端 axios.get('/list') 对应此端点
//     *   - 对应 app.js 中的 axios.get('/list')
//     */
//    @RequestMapping("/list")
//    public List<User> list() throws Exception {
//
//        // ===== 第1步：加载并读取 user.txt 文件 获取用户数据 =====
//        // 使用类加载器从 resources 目录加载 user.txt 文件
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
//
//        // 使用 hutool 工具类读取文件的所有行
//        // 参数说明：
//        //   - in: 输入流
//        //   - StandardCharsets.UTF_8: 文件编码为 UTF-8
//        //   - new ArrayList<>(): 存储行数据的集合
//        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
//
//        // ===== 第2步：解析用户信息 封装为 User 对象 -> List 集合 =====
//        // 使用 Stream API 处理数据
//        List<User> userList = lines.stream()           // 转换为流
//                .map(line -> {                          // map：转换操作，将每一行字符串转换为 User 对象
//                    String[] parts = line.split(",");   // 按逗号分割字符串
//                    Integer id = Integer.parseInt(parts[0]);                                                 // 解析 ID
//                    String username = parts[1];                                                             // 解析用户名
//                    String password = parts[2];                                                             // 解析密码
//                    String name = parts[3];                                                                 // 解析姓名
//                    Integer age = Integer.parseInt(parts[4]);                                               // 解析年龄
//                    LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));  // 解析时间
//                    return new User(id, username, password, name, age, updateTime);  // 创建 User 对象并返回
//                })
//                .collect(Collectors.toList());          // collect：将流转换回 List 集合
//
//        // ===== 第3步：返回数据（自动转换为 JSON） =====
//        // @RestController 会自动将 List<User> 序列化为 JSON 数组
//        // 前端接收到的数据格式：
//        // [
//        //   {id: 1, username: "daqiao", password: "1234567890", name: "大乔", age: 22, updateTime: "2024-07-15T15:05:45"},
//        //   {id: 2, username: "xiaoqiao", ...}
//        // ]
//        return userList;
//    }
//}
