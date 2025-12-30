package com.blockchain.experiment.service;

/**
 * @author Tenerife
 * Su san
 * @date 2025/12/30 16:35
 */

import com.blockchain.experiment.dao.BookDao;
import com.blockchain.experiment.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    // 业务逻辑：调用Dao层查询
    public List<Book> getBooks(String bookname) {
        return bookDao.getList(bookname);
    }

    // 业务逻辑：调用Dao层插入
    public boolean addBook(Book book) {
        int rows = bookDao.insertBook(book);
        return rows > 0;
    }
}
