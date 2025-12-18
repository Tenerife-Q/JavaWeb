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
     */
    @PostMapping("/regist1")
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
    public String registuser3(@ModelAttribute User user, Model model) { // [cite: 19]
        // SpringMVC 会自动根据 name 属性匹配 User 类的字段
        model.addAttribute("user", user);
        return "userinfo";
    }

    /**
     * 实验要求 11: 返回 List<User> JSON 数据
     * 映射地址 "/userlist"
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