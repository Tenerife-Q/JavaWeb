package com.springmvcexp2.entity;

/**
 * @author Tenerife
 * Su san
 * @date 2025/12/18 14:41
 */

// 如果没装 Lombok，请手动生成 Getter, Setter, 无参构造, 全参构造
public class User {
    private String uname;
    private String upwd;
    private Integer uage;

    // 1. 无参构造方法 (必须有)
    public User() {
    }

    // 2. 全参构造方法 (为了方便初始化)
    public User(String uname, String upwd, Integer uage) {
        this.uname = uname;
        this.upwd = upwd;
        this.uage = uage;
    }

    // 3. Getter 和 Setter 方法
    public String getUname() { return uname; }
    public void setUname(String uname) { this.uname = uname; }

    public String getUpwd() { return upwd; }
    public void setUpwd(String upwd) { this.upwd = upwd; }

    public Integer getUage() { return uage; }
    public void setUage(Integer uage) { this.uage = uage; }
}

/**
 * Spring MVC 执行流程原理？
 *
 *      结合代码理解：
 *
 *  1.你点了提交按钮 -> DispatcherServlet (前端控制器) 收到请求 。
 *
 *  2.它找到你的 UserController (@RequestMapping) 。
 *
 *  3.你的方法运行，把 user 塞进 Model，返回 "userinfo" 。
 *
 *  4.ViewResolver (视图解析器) 把 "userinfo" 变成 userinfo.html 。
 *
 *  5.Thymeleaf 把 Model 里的数据填进去，最后返回给浏览器 。
 */