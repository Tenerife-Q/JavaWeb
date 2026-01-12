package com.springmvcexp2.controller;

/**
 * @author Tenerife
 * Su san
 * @date 2025/12/18 14:46
 */

import com.springmvcexp2.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/*
@Controller 和 @RestController 的区别？（这里使用的是@Controller）

    结合代码理解：你的实验用的是 @Controller，所以 return "userinfo" 会跳转到 userinfo.html 页面。
    如果你换成 @RestController，浏览器上只会显示字符串 "userinfo"。

    背诵话术：
    @Controller：标识类为 Spring MVC 控制器，主要用于页面跳转 。

    @RestController：是 @Controller + @ResponseBody 的组合。
    它标识类为 REST 风格，所有方法默认返回 JSON 数据（不进行视图渲染）。
*/

@Controller
public class UserController {

    // 辅助方法：访问 http://localhost:8080/toRegister 进入注册页
    @GetMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    /**
     * 实验要求 7: 使用 @RequestParam 接收参数
     * 注意：为了避免路径冲突，我将其映射为 /regist1
     * 测试时需修改 html 的 action="/regist1"
     *
     * 接收 JSON (PPT 里的重点，实验扩展)
     * 考点：如果前端发来的是 JSON 格式（不是表单），必须用 @RequestBody。
     * 区别（死记）：@RequestParam 处理 key=value (表单/URL)，@RequestBody 处理 JSON 实体 。
     *
     */
    @PostMapping("/regist1")
    // 接收简单参数
    // HTML: <input name="uname">
    // @RequestParam 用于绑定 HTTP 请求参数（如 URL 参数或表单字段）到方法参数
    public String registuser1(@RequestParam("uname") String name,
                              @RequestParam("upwd") String pwd,
                              @RequestParam("uage") Integer age,
                              Model model) {
        User user = new User(name, pwd, age);
        model.addAttribute("user", user);
        return "userinfo"; // 跳转到 userinfo.html
    }

    /**
     * 实验要求 8: 使用 ModelAndView 达到相同效果
     * 映射为 /regist2
     */
    @PostMapping("/regist2")
    public ModelAndView registuser2(String uname, String upwd, Integer uage) {
        ModelAndView mv = new ModelAndView();
        User user = new User(uname, upwd, uage);
        mv.addObject("user", user);
        mv.setViewName("userinfo");
        return mv;
    }

    /**
     * 实验要求 9: 使用 @ModelAttribute (或直接对象接收)
     * 映射为 /regist (符合实验文档的核心要求)
     */
    @PostMapping("/regist")
    // HTML 表单有 uname, upwd, uage
    // @ModelAttribute：虽然代码里不写这个注解也能跑，但在理论上，它是用于绑定请求参数到模型对象 。
    public String registuser3(@ModelAttribute User user, Model model) { // [cite: 19]
        // SpringMVC 会自动根据 name 属性匹配 User 类的字段
        model.addAttribute("user", user);
        return "userinfo";
    }

    /**
     * 实验要求 11: 返回 List<User> JSON 数据
     * 映射地址 "/userlist"
     *
     * 使用 @ResponseBody 注解 。
     * 它告诉 Spring 跳过视图解析，直接把返回值（List/Object）写入 HTTP 响应体 。
     * 原理是利用 Jackson 库将 Java 对象序列化为 JSON 。
     */
    @RequestMapping("/userlist")
    @ResponseBody // 关键：不跳转页面，直接返回数据
    public List<User> getUsers() { //
        List<User> list = new ArrayList<>();
        list.add(new User("Alice", "111", 20));
        list.add(new User("Bob", "222", 21));
        list.add(new User("Charlie", "333", 22));
        list.add(new User("David", "444", 23));
        list.add(new User("Eve", "555", 24));
        return list;
    }
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