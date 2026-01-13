package com.exp3_bookmanagement.controller;

/**
 * @author Tenerife
 * Su san
 * @date 2025/12/23 15:04
 */

// 这里的 import 必须指向上面创建的 Book 类
import com.exp3_bookmanagement.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller// 解释：告诉 Spring 这是一个“控制器”。没有它，浏览器访问 /getallbooks 会报 404 错误
// 解释：这是一个声明。意思说：“只要有人往 Model 里放了一个叫 'sessionBooks' 的数据，请自动帮我同步存入 Session（保险柜）里”。
// 这样做的目的是为了让这份书单数据在页面跳转（列表页 -> 详情页）后依然存在
@SessionAttributes("sessionBooks")
public class BookController {
    // 存数据
    // 当浏览器地址栏输入 http://localhost:8080/getallbooks 时，就会执行下面这个方法
    @GetMapping("/getallbooks")
    public String getAllBooks(HttpSession session, Model model) {
        List<Book> books = new ArrayList<>();
        // 1. 造数据 模拟数据库查询
        // 确保图片文件名和 static/images 下的一致
        books.add(new Book("深入理解Java虚拟机", "97871111", "机械工业出版社", 99.0, "jvm.jpg"));
        books.add(new Book("Spring Boot实战", "97871112", "人民邮电出版社", 88.5, "springboot.jpg"));
        books.add(new Book("区块链技术指南", "97871113", "清华大学出版社", 120.0, "blockchain.jpg"));

        // 2. 【核心业务】存入 Session
        // 表面上看是存入 Model，但因为类头上有 @SessionAttributes("sessionBooks")，
        // 所以这个 list 实际上被存进了 Session（全剧通用的保险柜）
        model.addAttribute("sessionBooks", books);

        // 3. 指路
        // 返回字符串 "booklist"，Spring 会自动去 templates 目录下找 booklist.html 并渲染给用户
        return "booklist";
    }

    // 查数据
    @GetMapping("/getbook")
    public String getBook(@RequestParam("isbn") String isbn, HttpSession session, Model model) {
        // 1. 【核心业务】查 Session
        // 这是一个强制类型转换。从 Session 保险柜里把之前存的 "sessionBooks" 拿出来
        // 注意：这里用的是原生写法 session.getAttribute，与上面的注解配合使用了两种不同的 Session 操作方式。
        List<Book> books = (List<Book>) session.getAttribute("sessionBooks");
        // 2.  筛选逻辑代码
        if (books != null) {
            // 查询的书籍传进来的参数ISBN与数据库中某一本书的ISBN相同，就把它打包成单个book，返回给bookinfo.html演示
            for (Book book : books) {
                if (book.getBookisbn().equals(isbn)) {
                    model.addAttribute("book", book);
                    return "bookinfo";
                }
            }
        }
        // 3.  容错处理：如果没找到书或者 Session 空了，就踢回列表页
        return "redirect:/getallbooks";
    }
}
