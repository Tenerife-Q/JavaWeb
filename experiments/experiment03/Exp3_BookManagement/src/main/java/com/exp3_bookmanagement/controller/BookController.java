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

@Controller
@SessionAttributes("sessionBooks")
public class BookController {

    @GetMapping("/getallbooks")
    public String getAllBooks(HttpSession session, Model model) {
        List<Book> books = new ArrayList<>();
        // 确保图片文件名和 static/images 下的一致
        books.add(new Book("深入理解Java虚拟机", "97871111", "机械工业出版社", 99.0, "jvm.jpg"));
        books.add(new Book("Spring Boot实战", "97871112", "人民邮电出版社", 88.5, "springboot.jpg"));
        books.add(new Book("区块链技术指南", "97871113", "清华大学出版社", 120.0, "blockchain.jpg"));

        model.addAttribute("sessionBooks", books);
        return "booklist";
    }

    @GetMapping("/getbook")
    public String getBook(@RequestParam("isbn") String isbn, HttpSession session, Model model) {
        List<Book> books = (List<Book>) session.getAttribute("sessionBooks");

        if (books != null) {
            for (Book book : books) {
                if (book.getBookisbn().equals(isbn)) {
                    model.addAttribute("book", book);
                    return "bookinfo";
                }
            }
        }
        return "redirect:/getallbooks";
    }
}
