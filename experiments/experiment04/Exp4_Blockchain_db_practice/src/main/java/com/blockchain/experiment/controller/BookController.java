package com.blockchain.experiment.controller;

/**
 * @author Tenerife
 * Su san
 * @date 2025/12/30 16:35
 */

import com.blockchain.experiment.entity.Book;
import com.blockchain.experiment.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * GetBooks: 模糊查询
     * URL: /book/GetBooks?bookname=xx
     */
    @GetMapping("/GetBooks")
    public List<Book> GetBooks(@RequestParam("bookname") String bookname) {
        return bookService.getBooks(bookname);
    }

    /**
     * AddBook: 插入数据
     * URL: /book/AddBook
     * Body: JSON format
     */
    @PostMapping("/AddBook")
    public Boolean AddBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
}
